package com.jada.handlers.guild;

import com.jada.bot.Jada;
import org.json.JSONObject;


public class GuildRoleUpdateHandler  extends GuildHandler{

    public GuildRoleUpdateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
