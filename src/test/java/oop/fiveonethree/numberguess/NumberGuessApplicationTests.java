package oop.fiveonethree.numberguess;

import oop.fiveonethree.numberguess.mapper.UserMapper;
import oop.fiveonethree.numberguess.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberGuessApplicationTests {

    @Resource
    private UserMapper mapper;

    @Test
    public void contextLoads() {
        User u = new User();

        u.setUsername("zhouying");
        u.setPassword("123456");
        u.setId(3);
        mapper.save(u);

        u = new User();
        u.setUsername("zhou");
        u.setPassword("123");
        u.setId(2);
        mapper.save(u);

        u = new User();
        u.setUsername("ying");
        u.setPassword("456");
        u.setId(1);
        mapper.save(u);

        System.out.println(mapper.findAll());
    }

}
