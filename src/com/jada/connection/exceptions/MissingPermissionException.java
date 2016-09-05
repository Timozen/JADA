package com.jada.connection.exceptions;

import com.jada.models.PermissionConstants;
import com.jada.models.Permissions;

import java.util.List;

/**
 * Created by Derpie on 05.09.2016.
 */
public class MissingPermissionException extends Exception{
    public Permissions missingPerms;
    MissingPermissionException(Permissions missingPerms){
        this.missingPerms = missingPerms;
    }
}
