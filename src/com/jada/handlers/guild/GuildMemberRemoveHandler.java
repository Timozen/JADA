package com.jada.handlers.guild;

import com.jada.bot.Jada;
import org.json.JSONObject;

public class GuildMemberRemoveHandler extends GuildHandler {

    public GuildMemberRemoveHandler(Jada jada, int eventNumber) {
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
