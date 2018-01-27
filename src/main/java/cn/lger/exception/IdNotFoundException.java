package cn.lger.exception;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(){
        super("id找不到");
    }
}
