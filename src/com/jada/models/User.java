package com.jada.models;


public class User {

    private String id;
    private String username;
    private String discriminator;
    private String avatar;
    private String game;
    private String online_status;
    private boolean bot;
    private boolean mfa_enabled;
    private boolean verified;
    private boolean email;

    public User(){
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public User setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getGame() {
        return game;
    }

    public User setGame(String game) {
        this.game = game;
        return this;
    }

    public String getOnline_status() {
        return online_status;
    }

    public User setOnline_status(String online_status) {
        this.online_status = online_status;
        return this;
    }

    public boolean isBot() {
        return bot;
    }

    public User setBot(boolean bot) {
        this.bot = bot;
        return this;
    }

    public boolean isMfa_enabled() {
        return mfa_enabled;
    }

    public User setMfa_enabled(boolean mfa_enabled) {
        this.mfa_enabled = mfa_enabled;
        return this;
    }

    public boolean isVerified() {
        return verified;
    }

    public User setVerified(boolean verified) {
        this.verified = verified;
        return this;
    }

    public boolean isEmail() {
        return email;
    }

    public User setEmail(boolean email) {
        this.email = email;
        return this;
    }


}
