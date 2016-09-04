package com.jada.event.message;

import com.jada.bot.Jada;
import com.jada.event.Event;
import com.jada.models.Message;

/**
 * Created by Tim on 04.09.2016.
 */
public class PrivateMessageCreateEvent extends Event {

    public Message msg;

    public PrivateMessageCreateEvent(Jada jada, int eventNumber, Message msg){
        super(jada, eventNumber);
        this.msg = msg;
    }
}