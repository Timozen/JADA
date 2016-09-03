package com.jada.models;

/**
 * Created by Tim on 03.09.2016.
 */
public class Role {

    private String id;
    private String name;
    private int color;
    private boolean hoist;
    private int position;
    private int permissions;
    private boolean managed;
    private boolean mentionable;

    public String getId() {
        return id;
    }

    public Role setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Role setColor(int color) {
        this.color = color;
        return this;
    }

    public boolean isHoist() {
        return hoist;
    }

    public Role setHoist(boolean hoist) {
        this.hoist = hoist;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Role setPosition(int position) {
        this.position = position;
        return this;
    }

    public int getPermissions() {
        return permissions;
    }

    public Role setPermissions(int permissions) {
        this.permissions = permissions;
        return this;
    }

    public boolean isManaged() {
        return managed;
    }

    public Role setManaged(boolean managed) {
        this.managed = managed;
        return this;
    }

    public boolean isMentionable() {
        return mentionable;
    }

    public Role setMentionable(boolean mentionable) {
        this.mentionable = mentionable;
        return this;
    }
}
