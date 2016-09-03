package com.jada.handlers.message;

import com.jada.bot.Jada;
import com.jada.handlers.EventHandler;
import org.json.JSONObject;


public abstract class MessageHandler implements EventHandler{

    protected final Jada jada;
    protected final int eventNumber;
    protected JSONObject data;

    public MessageHandler(Jada jada, int eventNumber){
        this.jada = jada;
        this.eventNumber = eventNumber;
    }

    @Override
    public void handle(JSONObject obj){
        this.data = obj;

        String result = handleSpecific(obj.getJSONObject("d"));

        if(result == null){
            //System.out.println("everything went fine");
        }
    }
    public abstract String handleSpecific(JSONObject dData);
}
