package oop.fiveonethree.numberguess.controller;

import oop.fiveonethree.numberguess.exception.LoginException;
import oop.fiveonethree.numberguess.model.User;
import oop.fiveonethree.numberguess.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;

    @PostMapping("/login")
    public void userLogin(User user, HttpSession session) {
        if (service.loginUser(user)) {
            session.setAttribute("user", user);
        } else {
            throw new LoginException("用户不存在或密码不匹配!");
        }
    }
}
