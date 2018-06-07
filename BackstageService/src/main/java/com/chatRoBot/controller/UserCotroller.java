package com.chatRoBot.controller;

import com.chatRoBot.model.User;
import com.chatRoBot.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(value="username", required = false) String username,
                        @RequestParam(value="password", required = false) String password ) throws IOException {
        User user = this.userService.selectUser(username);
        Map<String, String> map = new HashMap<String, String>();
        if (password.equals(user.getPassword())) {
            map.put("msg", "1");
        } else {
            map.put("msg", "2");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
    /**
     * @param   username
     * @return
     */
    @RequestMapping(value = "/getRole.do" , method = RequestMethod.POST)
    public ModelAndView getRole(@RequestParam(value="username", required = false) String username){
        System.out.println(1111);
        ModelAndView model = new ModelAndView();
        model.setViewName("chatRoBot/backstageServiceMain");
        return model;
    }

}