package com.jada.handlers.connection;

import com.jada.bot.Jada;
import com.jada.builder.GuildBuilder;
import com.jada.models.Guild;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadyHandler extends ConnectionHandler {

    public ReadyHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject data) {

        jada.setSessionId(data.getString("session_id"));

        JSONArray privateChannels = data.getJSONArray("private_channels");
        for(int i = 0; i < privateChannels.length(); i++){
            //TODO
        }

        JSONArray guilds = data.getJSONArray("guilds");
        if(guilds.length() == 0){
            setReady();
        }else{
            for(int i = 0; i < guilds.length(); i++){
                new GuildBuilder(jada).create(guilds.getJSONObject(i));
            }
            setReady();
        }
        return null;
    }

    private void setReady(){
        jada.getSocketClient().ready();
    }
}
