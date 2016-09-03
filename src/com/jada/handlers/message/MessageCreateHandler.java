package com.jada.handlers.message;

import com.jada.bot.Jada;
import com.jada.models.Message;
import org.json.JSONObject;

public class MessageCreateHandler extends MessageHandler{

    public MessageCreateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);

    }

    @Override
    public String handleSpecific(JSONObject dData) {

        Message msg = Message.createMessage(dData);

        return null;
    }
}
