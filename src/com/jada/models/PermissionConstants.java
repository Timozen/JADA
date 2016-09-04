package com.jada.models;

/**
 * Created by Derpie on 04.09.2016.
 */
public enum PermissionConstants {
    CREATE_INSTANT_INVITE(0x00000001),
    KICK_MEMBERS(0x00000002),
    BAN_MEMBERS(0x00000004),
    ADMINISTRATOR(0x00000008),
    MANAGE_CHANNELS(0x00000010),
    MANAGE_GUILD(0x00000020),
    READ_MESSAGES(0x00000400),
    SEND_MESSAGES(0x00000800),
    SEND_TTS_MESSAGES(0x00001000),
    MANAGE_MESSAGES(0x00002000),
    EMBED_LINKS(0x00004000),
    ATTACH_FILES(0x00008000),
    READ_MESSAGE_HISTORY(0x00010000),
    MENTION_EVERYONE(0x00020000),
    CONNECT(0x00100000),
    SPEAK(0x00200000),
    MUTE_MEMBERS(0x00400000),
    DEAFEN_MEMBERS(0x00800000),
    MOVE_MEMBERS(0x01000000),
    USE_VAD(0x02000000),
    CHANGE_NICKNAME(0x04000000),
    MANAGE_NICKNAMES(0x08000000),
    MANAGE_ROLES(0x10000000);
    private long permissionValue;
    PermissionConstants(long permissionValue){
        this.permissionValue = permissionValue;
    }
    public long getValue(){
        return this.permissionValue;
    }
}
