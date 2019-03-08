package com.games24x7.kafka;

public class User {
    private String user_id;
    private String action_type;

    public User() {
    }

    public User(String user_id, String action_type) {
        this.user_id = user_id;
        this.action_type = action_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }
}
