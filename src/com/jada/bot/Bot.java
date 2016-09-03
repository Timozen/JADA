package com.jada.bot;

import com.jada.connection.SocketClient;

public class Bot {

    private String TOKEN;
    private boolean logging = false;
    private SocketClient socketClient;
    private Jada jadaStorage;

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

    public Bot build(){
        socketClient = new SocketClient(this.TOKEN, this.logging, this.jadaStorage);
        return this;
    }
}
