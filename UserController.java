package com.roncoo.controller.zwb;


import com.roncoo.UserService;
import com.roncoo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public List<User> userList(User user) {
        return userService.userList(user);
    }
}
