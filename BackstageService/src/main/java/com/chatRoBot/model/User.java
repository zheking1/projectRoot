package com.chatRoBot.model;

/**
 * Created by Asus on 2018/3/19.
 */
public class User {
    private String userUId;
    private String password;
    private String userName;
    private String sessionId;

    public User(String userUId, String password, String userName, String sessionId) {
        this.userUId = userUId;
        this.password = password;
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userUId='" + userUId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    public String getUserUId() {
        return userUId;
    }

    public void setUserUId(String userUId) {
        this.userUId = userUId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
