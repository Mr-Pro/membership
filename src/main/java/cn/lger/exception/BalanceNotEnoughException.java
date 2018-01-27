package cn.lger.exception;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
public class BalanceNotEnoughException extends RuntimeException{

    public BalanceNotEnoughException(){
        super("余额不足");
    }

}
