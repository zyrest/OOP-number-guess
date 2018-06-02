package oop.fiveonethree.numberguess.mapper;

import oop.fiveonethree.numberguess.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
public interface GameMapper extends JpaRepository<Game, Integer> {

    @Query("select userId, sum(score) as sum_score from Game group by userId order by sum_score desc")
    List<Object[]> selectSumScore();
}
