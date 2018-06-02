package oop.fiveonethree.numberguess.service;

import com.alibaba.fastjson.JSON;
import oop.fiveonethree.numberguess.mapper.GameMapper;
import oop.fiveonethree.numberguess.model.Game;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Service
public class GameService {

    @Resource
    private GameMapper mapper;

    public void storeGameInfo(Game game, Integer guessCount) {
        game.setGameTime(new Date());
        game.setScore(caculateScore(guessCount));

        System.out.println(game);

        mapper.save(game);
    }

    public List<Map<String, String>> getRank(int page) {
        int size = 1;
        int max = page * size;
        int start = (page-1) * size;

        List<Object[]> results = mapper.selectSumScore();
        List<Map<String, String>> ans = new ArrayList<>();
        max = (max > results.size()) ? results.size() : max;

        for (int j = start; j<max; j++) {
            Object[] result = results.get(j);
            Integer userId = ((Number) result[0]).intValue();
            Integer sumScore = ((Number) result[1]).intValue();

            Map<String, String> m = new HashMap<>();
            m.put("userId", userId.toString());
            m.put("sumScore", sumScore.toString());
            ans.add(m);
        }

        System.out.println(JSON.toJSONString(ans));
        return ans;
    }

    private int caculateScore(Integer count) {
        int score = 0;

        if (count > 0 && count <= 5) score = 5;
        else if (count > 5 && count <= 10) score = 4;
        else if (count > 10 && count <= 15) score = 3;
        else if (count > 15 && count <= 20) score = 2;
        else if (count > 20) score = 1;

        return score;
    }
}
