package oop.fiveonethree.numberguess.controller;

import oop.fiveonethree.numberguess.model.Game;
import oop.fiveonethree.numberguess.model.Message;
import oop.fiveonethree.numberguess.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Resource
    private GameService gameService;

    @PostMapping("/save")
    public Message saveGameInfo(@RequestBody Map<String, String> req) {
        Integer userId = Integer.valueOf(req.get("userId"));
        Integer guessCount = Integer.valueOf(req.get("guessCount"));

        Message message = new Message();

        Game game = new Game();
        game.setUserId(userId);
        gameService.storeGameInfo(game, guessCount);

        message.setStatus(Message.SUCCESS);
        return message;
    }
}
