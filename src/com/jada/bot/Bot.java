package com.jada.bot;

import com.jada.connection.SocketClient;
import com.jada.listener.EventListener;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    private String TOKEN;
    private boolean logging = false;
    private SocketClient socketClient;
    private Jada jadaStorage;
    private List<EventListener> listeners = new ArrayList<>();

    public Bot(){
        jadaStorage = new Jada();
    }

    public Bot setToken(String TOKEN){
        this.TOKEN = TOKEN;
        return this;
    }

    public Bot enableLoggin(boolean logging){
        this.logging = logging;
        return this;
    }

    public Bot addListener(EventListener listener){
        this.listeners.add(listener);
        return this;
    }

    public Bot build(){
        socketClient = new SocketClient(this.TOKEN, this.logging, this.jadaStorage);
        jadaStorage.setSocketClient(socketClient);
        listeners.forEach(listener -> jadaStorage.addEventListener(listener));

        return this;
    }



}
