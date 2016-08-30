package com.jada.events;

import com.jada.connection.SocketClient;

import org.json.JSONObject;

import java.util.logging.Logger;

public class EventHandler {

    private final SocketClient client;
    private final Logger logger;

    public EventHandler(SocketClient client, Logger logger){
        this.client = client;
        this.logger = logger;
    }

    public void handle(JSONObject data){
        String eventType = (String) data.get("t");
        JSONObject content = (JSONObject) data.get("d");

        switch (eventType){
            case "READY":
                logger.info("Received READY-Event");
                client.sessionId = (String) content.get("session_id");
                logger.info("New Session_Id: " + client.sessionId);
                break;

            case "GUILD_CREATE":
                break;
            default:
                break;
        }
    }
}
