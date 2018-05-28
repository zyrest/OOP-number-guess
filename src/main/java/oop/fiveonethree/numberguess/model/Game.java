package oop.fiveonethree.numberguess.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Data
@Entity
public class Game {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Date gameTime;

    @Column(nullable = false)
    private Integer score;
}
