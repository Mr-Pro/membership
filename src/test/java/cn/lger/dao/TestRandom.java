package cn.lger.dao;

import org.junit.Test;

import java.util.Random;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
public class TestRandom {

    @Test
    public void test01(){
        Random random = new Random();
        for (int i = 0; i <= 100; i++){
            System.out.println(random.nextInt(100));
        }
    }

}
