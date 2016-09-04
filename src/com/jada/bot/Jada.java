package com.jada.bot;

import com.jada.listener.EventListener;
import com.jada.manager.EventManager;
import com.jada.models.*;

import java.util.HashMap;

/**
 * This is the storage class for our bot
 */

public class Jada {
    public int responseTotal;
    private EventManager eventManager = new EventManager();

    private HashMap<String, Guild> guilds = new HashMap<>();
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, TextChannel> textChannels = new HashMap<>();
    private HashMap<String, VoiceChannel> voiceChannels = new HashMap<>();
    private HashMap<String, Role> roles = new HashMap<>();

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public HashMap<String, TextChannel> getTextChannels() {
        return textChannels;
    }

    public void setTextChannels(HashMap<String, TextChannel> textChannels) {
        this.textChannels = textChannels;
    }

    public HashMap<String, VoiceChannel> getVoiceChannels() {
        return voiceChannels;
    }

    public void setVoiceChannels(HashMap<String, VoiceChannel> voiceChannels) {
        this.voiceChannels = voiceChannels;
    }

    public HashMap<String, Role> getRoles() {
        return roles;
    }

    public void setRoles(HashMap<String, Role> roles) {
        this.roles = roles;
    }

    public void addEventListener(EventListener listener){
        eventManager.register(listener);
    }

    public EventManager getEventManager(){
        return eventManager;
    }

    public HashMap<String, Guild> getGuilds() { return guilds;}

    public void setGuilds(HashMap<String, Guild> guilds) { this.guilds = guilds; }
}
