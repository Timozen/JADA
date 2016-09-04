package com.jada.handlers.voice;

import com.jada.bot.Jada;
import com.jada.handlers.EventHandler;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
abstract class VoiceHandler implements EventHandler {

    protected Jada jada;
    protected int eventNumber;
    protected JSONObject data;

    public VoiceHandler(Jada jada, int eventNumber){
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
