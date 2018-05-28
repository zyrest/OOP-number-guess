package oop.fiveonethree.numberguess.controller;

import oop.fiveonethree.numberguess.exception.LoginException;
import oop.fiveonethree.numberguess.exception.NewResourceException;
import oop.fiveonethree.numberguess.model.Message;
import oop.fiveonethree.numberguess.model.User;
import oop.fiveonethree.numberguess.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;

    @PostMapping("/submit_login")
    public Message userLogin(User user, HttpSession session) {
        Message message = new Message();

        if (service.loginUser(user)) {
            message.setStatus(Message.SUCCESS);
            Map<String, String> data = new HashMap<>();
            data.put("id", user.getId().toString());
            data.put("userName", user.getUsername());
            message.setData(data);
            session.setAttribute("user", user);
        } else {
            throw new LoginException("用户不存在或密码不匹配!");
        }

        return message;
    }

    @PostMapping("/submit_register")
    public Message userRegister(User user, HttpSession session) {
        Message message = new Message();

        try {
            session.removeAttribute("user");
            service.registerUser(user); // 注册用户
            session.setAttribute("user", user); // 注册成功，自动登陆

            message.setStatus(Message.SUCCESS);
            Map<String, String> data = new HashMap<>();
            data.put("id", user.getId().toString());
            data.put("userName", user.getUsername());
            message.setData(data);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NewResourceException("创建用户失败！");
        }

        return message;
    }

    @GetMapping("/submit_logout")
    public void userLogout(HttpSession session) {
        session.removeAttribute("user");
    }
}
