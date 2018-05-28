package oop.fiveonethree.numberguess.Advisor;

import oop.fiveonethree.numberguess.exception.CommonException;
import oop.fiveonethree.numberguess.model.Message;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@RestControllerAdvice
public class CommonAdvisor {

    @ExceptionHandler(value = CommonException.class)
    public Message handleCommon(CommonException e) {
        Message m = new Message();
        m.setStatus(Message.FAIL);
        m.setMessage(e.getMessage());
        return m;
    }
}
