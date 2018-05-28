package oop.fiveonethree.numberguess.model;

import lombok.Data;

/**
 * Created by ZhouYing.
 * www.zhouying.xyz
 */
@Data
public class Message {

    public static final int SUCCESS = 200;

    public static final int FAIL = 400;

    private int status;

    private String message;

    private Object data;
}
