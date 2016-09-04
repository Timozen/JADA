package com.jada.connection;

import com.jada.bot.Jada;
import com.jada.handlers.channel.ChannelCreateHandler;
import com.jada.handlers.channel.ChannelDeleteHandler;
import com.jada.handlers.channel.ChannelUpdateHandler;
import com.jada.handlers.connection.ReadyHandler;
import com.jada.handlers.connection.ResumeHandler;
import com.jada.handlers.guild.*;
import com.jada.handlers.message.*;
import com.jada.handlers.user.PresenceUpdateHandler;
import com.jada.handlers.user.UserSettingsUpdateHandler;
import com.jada.handlers.user.UserUpdateHandler;
import com.jada.handlers.voice.VoiceServerUpdateHandler;
import com.jada.handlers.voice.VoiceStateUpdateHandler;
import org.json.JSONObject;

import java.util.logging.Logger;

class GatewayEventHandler {

    private final SocketClient client;
    private final Logger logger;

    public GatewayEventHandler(SocketClient client, Logger logger){
        this.client = client;
        this.logger = logger;
    }

    public void handle(JSONObject data){
        String eventType = (String) data.get("t");
        JSONObject content = (JSONObject) data.get("d");

        logger.info("Received " + eventType + "-Event");
        Jada jada = client.jadaStorage;
        int eventNumber = jada.responseTotal;

        switch (eventType){
            //Connection Events//
            case "READY":
                new ReadyHandler(jada, eventNumber).handle(data);
                break;
            case "RESUMED":
                new ResumeHandler(jada, eventNumber).handle(data);
                break;

            //Channel Events//
            case "CHANNEL_CREATE":
                new ChannelCreateHandler(jada, eventNumber).handle(data);
                break;
            case "CHANNEL_UPDATE":
                new ChannelUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "CHANNEL_DELETE":
                new ChannelDeleteHandler(jada, eventNumber).handle(data);
                break;

            //Guild Events//
            case "GUILD_CREATE":
                new GuildCreateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_UPDATE":
                new GuildUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_DELETE":
                new GuildDeleteHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_BAN_ADD":
                new GuildBanAddHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_BAN_REMOVE":
                new GuildBanRemoveHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_EMOJI_UPDATE":
                new GuildEmojiUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_INTEGRATION_UPDATE":
                new GuildIntegrationsUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_MEMBER_ADD":
                new GuildMemberAddHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_MEMBER_REMOVE":
                new GuildMemberRemoveHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_MEMBER_CHUNK":
                new GuildMemberChunkHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_ROLE_CREATE":
                new GuildRoleCreateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_ROLE_UPDATE":
                new GuildRoleUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "GUILD_ROLE_DELETE":
                new GuildRoleDeleteHandler(jada, eventNumber).handle(data);
                break;

            //Message Events//
            case "MESSAGE_CREATE":
                new MessageCreateHandler(jada, eventNumber).handle(data);
                break;
            case "MESSAGE_UPDATE":
                new MessageUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "MESSAGE_DELETE":
                new MessageDeleteHandler(jada, eventNumber).handle(data);
                break;
            case "MESSAGE_DELETE_BULK":
                new MessageDeleteBulkHandler(jada, eventNumber).handle(data);
                break;
            case "TYPING_START":
                new TypingStartHandler(jada, eventNumber).handle(data);
                break;

            //User events//
            case "USER_SETTINGS_UPDATE":
                new UserSettingsUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "USER_UPDATE":
                new UserUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "PRESENCE_UPDATE":
                new PresenceUpdateHandler(jada, eventNumber).handle(data);
                break;

            //Voice Events//
            case "VOICE_STATE_UPDATE":
                new VoiceStateUpdateHandler(jada, eventNumber).handle(data);
                break;
            case "VOICE_SERVER_UPDATE":
                new VoiceServerUpdateHandler(jada, eventNumber).handle(data);
                break;

            default:
                logger.warning("Unknown gateway event " + eventType);
                break;
        }
    }
}
