package com.jada.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Derpie on 04.09.2016.
 */
public class Permissions {
    private List<PermissionConstants> permissions;
    Permissions(long int_permissions){
        this.permissions = new ArrayList<>();
        if((int_permissions & 0x00000001) == 0x00000001){this.permissions.add(PermissionConstants.CREATE_INSTANT_INVITE);}
        if((int_permissions & 0x00000002) == 0x00000002){this.permissions.add(PermissionConstants.KICK_MEMBERS);}
        if((int_permissions & 0x00000004) == 0x00000004){this.permissions.add(PermissionConstants.BAN_MEMBERS);}
        if((int_permissions & 0x00000008) == 0x00000008){this.permissions.add(PermissionConstants.ADMINISTRATOR);}
        if((int_permissions & 0x00000010) == 0x00000010){this.permissions.add(PermissionConstants.MANAGE_CHANNELS);}
        if((int_permissions & 0x00000020) == 0x00000020){this.permissions.add(PermissionConstants.MANAGE_GUILD);}
        if((int_permissions & 0x00000400) == 0x00000400){this.permissions.add(PermissionConstants.READ_MESSAGES);}
        if((int_permissions & 0x00000800) == 0x00000800){this.permissions.add(PermissionConstants.SEND_MESSAGES);}
        if((int_permissions & 0x00001000) == 0x00001000){this.permissions.add(PermissionConstants.SEND_TTS_MESSAGES);}
        if((int_permissions & 0x00002000) == 0x00002000){this.permissions.add(PermissionConstants.MANAGE_MESSAGES);}
        if((int_permissions & 0x00004000) == 0x00004000){this.permissions.add(PermissionConstants.EMBED_LINKS);}
        if((int_permissions & 0x00008000) == 0x00008000){this.permissions.add(PermissionConstants.ATTACH_FILES);}
        if((int_permissions & 0x00010000) == 0x00010000){this.permissions.add(PermissionConstants.READ_MESSAGE_HISTORY);}
        if((int_permissions & 0x00020000) == 0x00020000){this.permissions.add(PermissionConstants.MENTION_EVERYONE);}
        if((int_permissions & 0x00100000) == 0x00100000){this.permissions.add(PermissionConstants.CONNECT);}
        if((int_permissions & 0x00200000) == 0x00200000){this.permissions.add(PermissionConstants.SPEAK);}
        if((int_permissions & 0x00400000) == 0x00400000){this.permissions.add(PermissionConstants.MUTE_MEMBERS);}
        if((int_permissions & 0x00800000) == 0x00800000){this.permissions.add(PermissionConstants.DEAFEN_MEMBERS);}
        if((int_permissions & 0x01000000) == 0x01000000){this.permissions.add(PermissionConstants.MOVE_MEMBERS);}
        if((int_permissions & 0x02000000) == 0x02000000){this.permissions.add(PermissionConstants.USE_VAD);}
        if((int_permissions & 0x04000000) == 0x04000000){this.permissions.add(PermissionConstants.CHANGE_NICKNAME);}
        if((int_permissions & 0x08000000) == 0x08000000){this.permissions.add(PermissionConstants.MANAGE_NICKNAMES);}
        if((int_permissions & 0x10000000) == 0x10000000){this.permissions.add(PermissionConstants.MANAGE_ROLES);}
    }
    /*
        hasPermission   -   Checks if permission is granted
        parameters:
            PermissionConstants p   -   Permission to check
        returns:
            type:   boolean
            true    -   Owns permission
            false   -   Does not own permission
     */
    public boolean hasPermission(PermissionConstants p){
        return this.permissions.contains(p);
    }

    /*
        addPermission   -   adds permission
        parameters:
            PermissionConstants p   -   Permission to add
        returns:
            this
     */
    public Permissions addPermission(PermissionConstants p){
        if(!this.permissions.contains(p)) {
            this.permissions.add(p);
        }
        return this;
    }

    /*
        removePermission    -   removes permission
        parameters:
            PermissionConstants p   -   Permission to remove
        returns:
            this
     */
    public Permissions removePermission(PermissionConstants p){
        this.permissions.remove(p);
        return this;
    }
}
