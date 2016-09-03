package com.jada.builder;

import com.jada.bot.Jada;
import com.jada.models.User;
import org.json.JSONObject;

public class UserBuilder extends Builder {

    public UserBuilder(Jada jada){
        super(jada);
    }

    @Override
    public User create(JSONObject obj){
        return null;
    }
}
