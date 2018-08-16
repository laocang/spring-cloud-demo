package com.teleware.entity;

public class userModel {

    private String id;
    private String logonid;
    private String  passwd;
    private String nick;
    private String serverMessage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogonid() {
        return logonid;
    }

    public void setLogonid(String logonid) {
        this.logonid = logonid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getServerMessage() {
        return serverMessage;
    }

    public void setServerMessage(String serverMessage) {
        this.serverMessage = serverMessage;
    }
}
