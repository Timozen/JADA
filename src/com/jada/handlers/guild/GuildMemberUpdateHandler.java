package com.jada.handlers.guild;

import com.jada.bot.Jada;
import org.json.JSONObject;

public class GuildMemberUpdateHandler  extends GuildHandler{

    public GuildMemberUpdateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
