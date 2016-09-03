package com.jada.models;


import org.json.JSONObject;

public class Message {

    public String id;
    public String channel_id;
    public User author;
    public String content;
    public String timestamp;
    public String edited_timestamp;
    public boolean tts;
    public boolean mention_everyone;
    public User[] mentions;
    public Role[] mention_role;
    //public Attachment[] attachments;
    //public Embeds[] embeds;
    public int nonce;
    public boolean pinned;

    public Message(){

    }

    public static Message createMessage(JSONObject content){
        Message m = new Message();

        return m;
    }

}
