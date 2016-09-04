package com.jada.handlers.user;

import com.jada.bot.Jada;
import org.json.JSONObject;

/**
 * Created by Tim on 04.09.2016.
 */
public class UserSettingsUpdateHandler extends UserHandler {

    public UserSettingsUpdateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject data){
        return null;
    }
}
