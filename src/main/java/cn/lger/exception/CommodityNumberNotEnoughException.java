package cn.lger.exception;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-17.
 */
public class CommodityNumberNotEnoughException extends RuntimeException{

    public CommodityNumberNotEnoughException(){
        super("商品数量不足");
    }

}
