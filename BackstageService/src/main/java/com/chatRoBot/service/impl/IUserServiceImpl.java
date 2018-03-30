package com.chatRoBot.service.impl;

import com.chatRoBot.dao.UserDao;
import com.chatRoBot.model.User;
import com.chatRoBot.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;

    public User selectUser(String userName) {
        return this.userDao.selectUser(userName);
    }

}