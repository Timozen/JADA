package com.jada.handlers.connection;

import com.jada.bot.Jada;
import com.sun.jndi.ldap.Connection;
import org.json.JSONObject;

public class ReadyHandler extends ConnectionHandler {

    public ReadyHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject d) {
        return null;
    }
}
