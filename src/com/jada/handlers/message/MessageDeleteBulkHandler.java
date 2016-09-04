package com.jada.handlers.message;

import com.jada.bot.Jada;
import org.json.JSONObject;

public class MessageDeleteBulkHandler extends MessageHandler{

    public MessageDeleteBulkHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject dData) {
        return null;
    }
}

