package com.jada.handlers.channel;

import com.jada.bot.Jada;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
public class ChannelCreateHandler extends ChannelHandler{

    public ChannelCreateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
