package com.jada.manager;

import com.jada.event.Event;
import com.jada.listener.EventListener;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener listener){
        listeners.add(listener);
    }

    public void unregister(EventListener listener){
        listeners.remove(listener);
    }

    public List<EventListener> getListeners(){
        return listeners;
    }

    public void handle(Event event){
        listeners.forEach(listener -> listener.onEvent(event));
    }

}
