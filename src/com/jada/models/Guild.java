package com.jada.models;

import org.json.JSONObject;

import java.util.HashMap;

public class Guild {

    private String id;
    private String name;
    private String icon;
    private String splash;
    private String owner_id;
    private String region;
    private String afk_channel_id;
    private int afk_timeout;
    private boolean embed_enabled;
    private String embed_channel_id;
    private int verification_level;
    private VoiceState[] voice_states;
    private Emoji[] emojis;
    //public Object features
    private boolean unavailable;

    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, TextChannel> textChannels = new HashMap<>();

    public HashMap<String, Role> getRoles() {
        return roles;
    }

    private HashMap<String, VoiceChannel> voiceChannels = new HashMap<>();
    private HashMap<String, Role> roles = new HashMap<>();

    public void setRoles(HashMap<String, Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public Guild setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Guild setName(String name) {
        this.name = name;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Guild setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getSplash() {
        return splash;
    }

    public Guild setSplash(String splash) {
        this.splash = splash;
        return this;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public Guild setOwner_id(String owner_id) {
        this.owner_id = owner_id;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Guild setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getAfk_channel_id() {
        return afk_channel_id;
    }

    public Guild setAfk_channel_id(String afk_channel_id) {
        this.afk_channel_id = afk_channel_id;
        return this;
    }

    public int getAfk_timeout() {
        return afk_timeout;
    }

    public Guild setAfk_timeout(int afk_timeout) {
        this.afk_timeout = afk_timeout;
        return this;
    }

    public boolean isEmbed_enabled() {
        return embed_enabled;
    }

    public Guild setEmbed_enabled(boolean embed_enabled) {
        this.embed_enabled = embed_enabled;
        return this;
    }

    public String getEmbed_channel_id() {
        return embed_channel_id;
    }

    public Guild setEmbed_channel_id(String embed_channel_id) {
        this.embed_channel_id = embed_channel_id;
        return this;
    }

    public int getVerification_level() {
        return verification_level;
    }

    public Guild setVerification_level(int verification_level) {
        this.verification_level = verification_level;
        return this;
    }

    public VoiceState[] getVoice_states() {
        return voice_states;
    }

    public Guild setVoice_states(VoiceState[] voice_states) {
        this.voice_states = voice_states;
        return this;
    }

    public Emoji[] getEmojis() {
        return emojis;
    }

    public Guild setEmojis(Emoji[] emojis) {
        this.emojis = emojis;
        return this;
    }

    public boolean isUnavailable() {
        return unavailable;
    }

    public Guild setUnavailable(boolean unavailable) {
        this.unavailable = unavailable;
        return this;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public Guild setUsers(HashMap<String, User> users) {
        this.users = users;
        return this;
    }

    public HashMap<String, TextChannel> getTextChannels() {
        return textChannels;
    }

    public Guild setTextChannels(HashMap<String, TextChannel> textChannels) {
        this.textChannels = textChannels;
        return this;
    }

    public HashMap<String, VoiceChannel> getVoiceChannels() {
        return voiceChannels;
    }

    public Guild setVoiceChannels(HashMap<String, VoiceChannel> voiceChannels) {
        this.voiceChannels = voiceChannels;
        return this;
    }


}
