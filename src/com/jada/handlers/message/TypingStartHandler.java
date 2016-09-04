package com.jada.handlers.message;

import com.jada.bot.Jada;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
public class TypingStartHandler extends MessageHandler{

    public TypingStartHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject dData) {
        return null;
    }
}

