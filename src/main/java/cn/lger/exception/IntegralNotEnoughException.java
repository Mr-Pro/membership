package cn.lger.exception;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
public class IntegralNotEnoughException extends RuntimeException{

    public IntegralNotEnoughException(){
        super("账户积分不足");
    }

}
