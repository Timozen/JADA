package com.jada.handlers.message;

import com.jada.bot.Jada;
import com.jada.models.Message;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
public class MessageUpdateHandler extends MessageHandler{

    public MessageUpdateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject dData) {
        return null;
    }
}


