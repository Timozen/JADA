package com.jada.listener;

import com.jada.event.Event;
import com.jada.event.message.GuildMessageCreateEvent;
import com.jada.event.message.MessageCreateEvent;
import com.jada.event.message.PrivateMessageCreateEvent;

public abstract class MessageListener implements EventListener {

    public void onMessageCreate(MessageCreateEvent event){}
    public void onPrivateMessageCreate(PrivateMessageCreateEvent event){}
    public void onGuildMessageCreate(GuildMessageCreateEvent event){}

    @Override
    public void onEvent(Event event) {

        if(event instanceof MessageCreateEvent){
            onMessageCreate((MessageCreateEvent) event);
        }else if(event instanceof PrivateMessageCreateEvent){
            onPrivateMessageCreate((PrivateMessageCreateEvent) event);
        }else if(event instanceof GuildMessageCreateEvent){
            onGuildMessageCreate((GuildMessageCreateEvent) event);
        }
    }
}
