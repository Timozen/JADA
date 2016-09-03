package com.jada.listener;



public abstract class MessageListener implements EventListener {

    public void onMessageCreate(String msg){}
    public void onPrivateMessageCreate(String msg){}
    public void onGuildMessageCreate(String msg){}

    @Override
    public void onEvent(String string) {
        onMessageCreate(string);
    }
}
