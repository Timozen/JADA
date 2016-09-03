package com.jada.builder;

import com.jada.bot.Jada;
import org.json.JSONObject;

public abstract class Builder {

    protected Jada jada;

    public Builder(Jada jada){
        this.jada = jada;
    }

    public abstract Object create(JSONObject obj);
}
