package com.jada.connection;

import com.jada.bot.Jada;
import com.neovisionaries.ws.client.*;
import org.json.JSONException;
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
        logger.info("Connect to Websocket");

        client.connectionStatus = ConnectionStatus.CONNECTED_WITHOUT_HANDSHAKE;

        if(client.sessionId == null){
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
                client.eventHandler.handle(content);
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                logger.info("OP: 10 - Received the HelloPayload - Init the KeepAliveHeartbeat");
                client.startKeepAlive(content.getJSONObject("d").getLong("heartbeat_interval"));
                break;
            case 11:
                logger.info("OP: 11 - The last heartbeat was successful");
                break;
            default:
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

    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception) throws Exception {
        super.onConnectError(websocket, exception);
    }

    @Override
    public void onStateChanged(WebSocket websocket, WebSocketState newState) throws Exception {
    }

    @Override
    public void onFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onFrame(websocket, frame);
    }

    @Override
    public void onContinuationFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onContinuationFrame(websocket, frame);
    }

    @Override
    public void onTextFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onTextFrame(websocket, frame);
    }

    @Override
    public void onBinaryFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onBinaryFrame(websocket, frame);
    }

    @Override
    public void onCloseFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onCloseFrame(websocket, frame);
    }

    @Override
    public void onPingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onPingFrame(websocket, frame);
    }

    @Override
    public void onPongFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onPongFrame(websocket, frame);
    }

    @Override
    public void onBinaryMessage(WebSocket websocket, byte[] binary) throws Exception {
        super.onBinaryMessage(websocket, binary);
    }

    @Override
    public void onSendingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onSendingFrame(websocket, frame);
    }

    @Override
    public void onFrameSent(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onFrameSent(websocket, frame);
    }

    @Override
    public void onFrameUnsent(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onFrameUnsent(websocket, frame);
    }

    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
        super.onError(websocket, cause);
    }

    @Override
    public void onFrameError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
        super.onFrameError(websocket, cause, frame);
    }

    @Override
    public void onMessageError(WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) throws Exception {
        super.onMessageError(websocket, cause, frames);
    }

    @Override
    public void onMessageDecompressionError(WebSocket websocket, WebSocketException cause, byte[] compressed) throws Exception {
        super.onMessageDecompressionError(websocket, cause, compressed);
    }

    @Override
    public void onTextMessageError(WebSocket websocket, WebSocketException cause, byte[] data) throws Exception {
        super.onTextMessageError(websocket, cause, data);
    }

    @Override
    public void onSendError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
        super.onSendError(websocket, cause, frame);
    }

    @Override
    public void onUnexpectedError(WebSocket websocket, WebSocketException cause) throws Exception {
        super.onUnexpectedError(websocket, cause);
    }

    @Override
    public void handleCallbackError(WebSocket websocket, Throwable cause) throws Exception {
        super.handleCallbackError(websocket, cause);
    }
}
