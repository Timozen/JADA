package com.jada.event;

import com.jada.bot.Jada;

/**
 * Created by Tim on 04.09.2016.
 */
public abstract class Event {

    public Jada jada;
    public int eventNumber;

    public Event(Jada jada, int eventNumber){
        this.jada = jada;
        this.eventNumber = eventNumber;
    }
}
