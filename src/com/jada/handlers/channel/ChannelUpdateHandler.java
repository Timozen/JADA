package com.jada.handlers.channel;

import com.jada.bot.Jada;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
public class ChannelUpdateHandler extends ChannelHandler{

    public ChannelUpdateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
