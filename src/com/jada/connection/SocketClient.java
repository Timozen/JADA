package com.jada.connection;

import com.jada.bot.Jada;
import com.jada.utils.LogCreator;
import com.jada.connection.exceptions.CouldNotFetchGatewayException;

import com.neovisionaries.ws.client.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.logging.Logger;


public class SocketClient {

    final String token;
    private String gateway_url;
    public String sessionId;
    ConnectionStatus connectionStatus;

    private WebSocket socket;
    final GatewayEventHandler gatewayEventHandler;
    private final SocketListener socketListener;

    public Jada jadaStorage;

    private final Logger logger;

    public SocketClient(String token, boolean debugLog, Jada jadaStorage){
        this.token = token;
        this.logger = LogCreator.createLogger("SocketClient", debugLog);
        this.jadaStorage = jadaStorage;
        this.gatewayEventHandler = new GatewayEventHandler(this, logger);
        this.socketListener = new SocketListener(this, logger);


        try {
            connect();
        } catch (CouldNotFetchGatewayException | IOException | WebSocketException e) {
            e.printStackTrace();
        }
    }

    void startKeepAlive(long timeOut){
        KeepAliveThread keepAliveThread = new KeepAliveThread(this, timeOut);
        keepAliveThread.setPriority(Thread.MAX_PRIORITY);
        keepAliveThread.setDaemon(true);
        keepAliveThread.start();
        logger.info("KeepAliveThread successfully started");
    }


    private void connect() throws CouldNotFetchGatewayException, IOException, WebSocketException {
        WebSocketFactory factory = new WebSocketFactory();

        if(gateway_url == null){
            gateway_url = getGateWay();
            if(gateway_url == null){
                throw new CouldNotFetchGatewayException();
            }
        }

        //TODO proxy settings etc...
        socket = factory.createSocket(gateway_url)
                .addListener(socketListener)
                .addHeader("Accept-Encoding", "gzip")
                .connect();
    }

    private String getGateWay(){
        if(gateway_url != null){
            return gateway_url;
        }else{
            //TODO: gateway neu holen, derzeit noch hardcoded
            return "wss://gateway.discord.gg/?v=6&encoding=json";
        }
    }

    void sendMessage(JSONObject msg) {
        logger.info("Send Message to Websocket\n" + msg.toString(4));
        socket.sendText(msg.toString());
    }

    public void closeSession(){
        socket.disconnect();
    }

}
