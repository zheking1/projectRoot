package com.chatRoBot.controller;

import com.chatRoBot.model.User;
import com.chatRoBot.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserCotroller {

    @Resource
    private IUserService userService;

    /**
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = this.userService.selectUser(username);
        user.toString();
        if (password.equals(user.getPassword())) {
            return "backstageServiceMain";
        } else {
            return "index";
        }
    }

}