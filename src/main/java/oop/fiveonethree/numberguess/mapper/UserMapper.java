package oop.fiveonethree.numberguess.mapper;

import oop.fiveonethree.numberguess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
public interface UserMapper extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    
}
