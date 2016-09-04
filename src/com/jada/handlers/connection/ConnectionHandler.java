package com.jada.handlers.connection;

import com.jada.bot.Jada;
import com.jada.handlers.EventHandler;
import org.json.JSONObject;

abstract class ConnectionHandler implements EventHandler {

    protected Jada jada;
    protected int eventNumber;
    protected JSONObject data;

    public ConnectionHandler(Jada jada, int eventNumber){
        this.jada = jada;
        this.eventNumber = eventNumber;
    }

    @Override
    public void handle(JSONObject obj) {
        this.data = obj;

        String res = handleSpecific(obj.getJSONObject("d"));

    }

    public abstract String handleSpecific(JSONObject d);
}