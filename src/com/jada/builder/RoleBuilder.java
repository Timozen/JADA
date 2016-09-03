package com.jada.builder;

import com.jada.bot.Jada;
import com.jada.models.Role;
import org.json.JSONObject;

public class RoleBuilder extends Builder{

    public RoleBuilder(Jada jada){
        super(jada);
    }

    @Override
    public Role create(JSONObject content) {

        String id = content.getString("id");
        Role role = jada.getRoles().get(id);

        if(role == null){
            role.setId(id);
            jada.getRoles().put(id, role);
        }

        role.setColor(content.getInt("color"))
                .setPermissions(content.getInt("permissions"))
                .setManaged(content.getBoolean("managed"))
                .setName(content.getString("name"))
                .setMentionable(content.getBoolean("mentionable"))
                .setPosition(content.getInt("position"))
                .setHoist(content.getBoolean("hoist"));

        return role;
    }
}
