package com.jada.handlers.guild;


import com.jada.bot.Jada;
import com.jada.builder.GuildBuilder;
import com.jada.models.Guild;
import org.json.JSONObject;

public class GuildCreateHandler extends GuildHandler {

    public GuildCreateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        new GuildBuilder(jada).create(d);
        return null;
    }
}
