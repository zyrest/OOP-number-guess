package oop.fiveonethree.numberguess.controller;

import oop.fiveonethree.numberguess.model.Message;
import oop.fiveonethree.numberguess.model.User;
import oop.fiveonethree.numberguess.service.GameService;
import oop.fiveonethree.numberguess.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@RestController
@RequestMapping("/rank")
public class RankController {

    @Resource
    private UserService userService;
    @Resource
    private GameService gameService;

    @GetMapping("/{page}")
    public Message getRankPage(@PathVariable int page) {
        Message message = new Message();

        List<Map<String, String>> ans = gameService.getRank(page);
        for (Map<String, String> one : ans) {
            Integer userId = Integer.valueOf(one.get("userId"));
            User user = userService.getUserById(userId);
            one.put("userName", user.getUsername());
        }

        message.setStatus(Message.SUCCESS);
        message.setData(ans);
        return message;
    }

}
