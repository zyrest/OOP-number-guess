package oop.fiveonethree.numberguess.service;

import oop.fiveonethree.numberguess.mapper.UserMapper;
import oop.fiveonethree.numberguess.model.User;
import oop.fiveonethree.numberguess.util.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Service
public class UserService {

    @Resource
    private UserMapper mapper;

    public void addUser(User user) {
        user.setId(null);
        user.setPassword(PasswordUtil.createHash(user.getPassword()));
        mapper.save(user);
    }

    public List<User> getAllUsers() {
        return mapper.findAll();
    }

    public boolean loginUser(User user) {
        User target = mapper.findByUsername(user.getUsername());

        return PasswordUtil.validatePassword(user.getPassword(), target.getPassword());
    }
}
