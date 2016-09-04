package com.jada.connection;

import com.neovisionaries.ws.client.*;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

class SocketListener extends WebSocketAdapter {

    private final SocketClient client;
    private final Logger logger;


    public SocketListener(SocketClient client, Logger logger){
        this.client = client;
        this.logger = logger;
    }

    @Override
    public void onConnected(WebSocket socket, Map<String, List<String>> headers) {
        logger.info("Connected to Websocket");

        client.connectionStatus = ConnectionStatus.CONNECTED_WITHOUT_HANDSHAKE;

        if(client.jadaStorage.getSessionId() == null){
            sendIdentification();
        }else{
            //TODO zeigen, dass wir wieder da sind
            sendReconnect();
        }


        client.connectionStatus = ConnectionStatus.CONNECTED_WITH_HANDSHAKE;
    }

    private void sendIdentification() {
        JSONObject identification = new JSONObject();

        identification.put("op", 2);
        identification.put("d", new JSONObject()
                .put("token", client.token)
                .put("properties", new JSONObject()
                    .put("$os", System.getProperty("os.name"))
                    .put("$browser", "Günther")
                    .put("$device", "Günther")
                    .put("$referrer", "")
                    .put("$referrer_domain", ""))
                .put("v", "6")
                .put("compress", false)
                .put("large_threshold", 250)
            );

        client.sendMessage(identification);
    }

    private void sendReconnect(){
    }

    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
        JSONObject content = new JSONObject(text);

        logger.info("Received new Message from Websocket\n" + content.toString(4));

        int opCode = content.getInt("op");

        if(content.has("s") && !content.isNull("s")){
            client.jadaStorage.responseTotal = content.getInt("s");
        }

        switch (opCode){
            case 0:
                client.gatewayEventHandler.handle(content);
                break;
            case 10:
                logger.info("OP: 10 - Received the HelloPayload - Init the KeepAliveHeartbeat");
                client.startKeepAlive(content.getJSONObject("d").getLong("heartbeat_interval"));
                break;
            case 11:
                logger.info("OP: 11 - The last heartbeat was successful");
                break;
            default:
                logger.warning("UNKNOWN OP " + opCode + " Add case");
                break;
        }
    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
        logger.info("Disconnected from Websocket - Socket disconnect: " + closedByServer
                +"\nReason: "+ serverCloseFrame.getCloseReason()
                +"\nCode  : "+ serverCloseFrame.getCloseCode()
                );

        client.connectionStatus = closedByServer ? ConnectionStatus.DISCONNECTED_BY_SERVER : ConnectionStatus.DISCONNECTED_BY_BOT;
    }
}
