package com.jada.connection;

import com.jada.connection.SocketClient;

import com.jada.handlers.guild.GuildCreateHandler;
import com.jada.handlers.message.MessageCreateHandler;
import org.json.JSONObject;

import java.util.logging.Logger;

class GatewayEventHandler {

    private final SocketClient client;
    private final Logger logger;

    public GatewayEventHandler(SocketClient client, Logger logger){
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
                logger.info("Received GUILD_CREATE event");
                new GuildCreateHandler(client.jadaStorage, client.jadaStorage.responseTotal).handle(data);
                break;
            case "MESSAGE_CREATE":
                logger.info("Received MESSAGE_CREATE event");
                new MessageCreateHandler(client.jadaStorage, client.jadaStorage.responseTotal).handle(data);
                break;
            default:
                logger.warning("Unknown gateway event " + eventType);
                break;
        }
    }
}
