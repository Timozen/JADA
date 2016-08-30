package com.jada.connection;

import org.json.JSONObject;

class KeepAliveThread extends Thread {

    private final SocketClient client;
    private final long timeOut;

    public KeepAliveThread(SocketClient client, long timeOut){
        this.client = client;
        this.timeOut = timeOut;
    }

    @Override
    public void run(){
        while(client.connectionStatus == ConnectionStatus.CONNECTED_WITH_HANDSHAKE){
            try {
                sendHeartBeat();
                sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendHeartBeat(){
        client.sendMessage(new JSONObject().put("op", 1).put("d", client.responseTotal));
    }


}
