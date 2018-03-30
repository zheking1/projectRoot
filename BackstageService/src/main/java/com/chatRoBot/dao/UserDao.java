package com.chatRoBot.dao;

import com.chatRoBot.model.User;

public interface UserDao {

    User selectUser(String id);

}