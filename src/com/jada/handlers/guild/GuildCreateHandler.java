package com.jada.handlers.guild;


import com.jada.bot.Jada;
import com.jada.builder.GuildBuilder;
import com.jada.models.Guild;
import org.json.JSONObject;

public class GuildCreateHandler extends GuildHandler {

    public GuildCreateHandler(Jada jada, int eventNumber){
        super(jada, eventNumber);
    }

    @Override
    public String handleSpecific(JSONObject data) {

        String id = data.getString("id");
        Guild guild = jada.getGuilds().get(id);

        boolean oldUnavailableState = (guild == null) ? null : guild.isUnavailable();

        if(guild == null){
            new GuildBuilder(jada).create(data);

            //fire new GuildJoinEvent -- bot joined new guild
        }else{
            new GuildBuilder(jada).create(data);

            if(!guild.isUnavailable()){

            }else{
                //fire new GuildJoinUnavailable
            }
        }
        return null;
    }
}
