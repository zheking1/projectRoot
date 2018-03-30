package com.chatRoBot.controller;

import com.chatRoBot.model.User;
import com.chatRoBot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 2018/3/22.
 */
@Controller
@RequestMapping("/check")
public class checkCotroller {
    private static final Log log = LogFactory.getLog(CaptchaController.class);
    @Resource
    private IUserService userService;

    /**
     * @param username
     */
    @RequestMapping(value = "/usernameCheck", method = RequestMethod.POST)
    @ResponseBody
    public String userNameCheck(@RequestParam(value = "username", required = false) String username) throws IOException {
        User user = this.userService.selectUser(username);
        Map<String, String> map = new HashMap<String, String>();
        if (user != null) {
            map.put("msg", "1");
        } else {
            map.put("msg", "2");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
