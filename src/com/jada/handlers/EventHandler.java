package com.jada.handlers;

import org.json.JSONObject;



public interface EventHandler {

    void handle(JSONObject obj);
}
