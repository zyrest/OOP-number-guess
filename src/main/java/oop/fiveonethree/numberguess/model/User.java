package oop.fiveonethree.numberguess.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // 该注解一定要在getter方法上, 为了 save 后返回相应 id 回对象
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }
}
