package oop.fiveonethree.numberguess;

import oop.fiveonethree.numberguess.controller.RankController;
import oop.fiveonethree.numberguess.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberGuessApplicationTests {

    @Resource
    private RankController controller;

    @Resource
    private GameService service;

    @Test
    public void contextLoads() {

    }

}
