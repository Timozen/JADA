package com.jada.builder;

import com.jada.bot.Jada;
import com.jada.models.Guild;
import com.jada.models.Role;
import org.json.JSONArray;
import org.json.JSONObject;

public class GuildBuilder extends Builder {

    public GuildBuilder(Jada jada){
        super(jada);
    }

    @Override
    public Guild create(JSONObject content) {
        String id = content.getString("id");
        Guild guild = jada.getGuilds().get(id);

        if(guild == null){
            guild = new Guild().setId(id);
            jada.getGuilds().put(id, guild);
        }
        if(content.has("unavailable") && content.getBoolean("unavailable")){
            guild.setUnavailable(true);
            return guild;
        }

        guild.setUnavailable(false)
                .setIcon(content.isNull("icon") ? null : content.getString("icon"))
                .setVerification_level(content.getInt("verification_level"))
                .setAfk_timeout(content.getInt("afk_timeout"))
                .setOwner_id(content.getString("owner_id"))
                .setRegion(content.getString("region"))
                .setName(content.getString("name"))
                .setAfk_channel_id(content.isNull("afk_channel_id") ? null : content.getString("afk_channel_id"));

        JSONArray roles = content.getJSONArray("roles");
        for(int i = 0; i < roles.length(); i++){
            Role role = new RoleBuilder(jada).create(roles.getJSONObject(i));
            guild.getRoles().put(role.getId(), role);
        }

        if(content.has("members")){

        }
        if(content.has("emojis")){

        }
        if(content.has("presences")){

        }
        return guild;
    }
}
