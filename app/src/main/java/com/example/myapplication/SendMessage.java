package com.example.myapplication;

public class SendMessage {

    private String _id ;
    private String content ;
    private String time ;
    private String fromWho ;
    private String toWho   ;
    private boolean isMySending ;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public boolean isMySending() {
        return isMySending;
    }

    public void setMySending(boolean mySending) {
        isMySending = mySending;
    }
}
