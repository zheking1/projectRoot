package com.chatRoBot.service;

import com.chatRoBot.model.User;

public interface IUserService {

    public User selectUser(String username);

}