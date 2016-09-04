package com.jada.models;

/**
 * Created by Derpie on 04.09.2016.
 */
public enum PermissionConstants {
    CREATE_INSTANT_INVITE(0x00000001, "CREATE_INSTANT_INVITE"),
    KICK_MEMBERS(0x00000002, "KICK_MEMBERS"),
    BAN_MEMBERS(0x00000004, "BAN_MEMBERS"),
    ADMINISTRATOR(0x00000008, "ADMINISTRATOR"),
    MANAGE_CHANNELS(0x00000010, "MANAGE_CHANNELS"),
    MANAGE_GUILD(0x00000020, "MANAGE_GUILD"),
    READ_MESSAGES(0x00000400, "READ_MESSAGES"),
    SEND_MESSAGES(0x00000800, "SEND_MESSAGES"),
    SEND_TTS_MESSAGES(0x00001000, "SEND_TTS_MESSAGES"),
    MANAGE_MESSAGES(0x00002000, "MANAGE_MESSAGES"),
    EMBED_LINKS(0x00004000, "EMBED_LINKS"),
    ATTACH_FILES(0x00008000, "ATTACH_FILES"),
    READ_MESSAGE_HISTORY(0x00010000, "READ_MESSAGE_HISTORY"),
    MENTION_EVERYONE(0x00020000, "MENTION_EVERYONE"),
    CONNECT(0x00100000, "CONNECT"),
    SPEAK(0x00200000, "SPEAK"),
    MUTE_MEMBERS(0x00400000, "MUTE_MEMBERS"),
    DEAFEN_MEMBERS(0x00800000, "DEAFEN_MEMBERS"),
    MOVE_MEMBERS(0x01000000, "MOVE_MEMBERS"),
    USE_VAD(0x02000000, "USE_VAD"),
    CHANGE_NICKNAME(0x04000000, "CHANGE_NICKNAME"),
    MANAGE_NICKNAMES(0x08000000, "MANAGE_NICKNAMES"),
    MANAGE_ROLES(0x10000000, "MANAGE_ROLES");
    private long permissionValue;
    private String permissionName;
    PermissionConstants(long permissionValue,
                        String permissionName){
        this.permissionValue = permissionValue;
        this.permissionName = permissionName;
    }
    public long getValue(){return this.permissionValue;}
    public String getName(){return this.permissionName;}
}
