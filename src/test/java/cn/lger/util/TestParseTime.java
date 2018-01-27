package cn.lger.util;

import org.junit.Test;

import java.time.LocalDate;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-15.
 */
public class TestParseTime {

    @Test
    public void test01(){
        System.out.println(LocalDate.parse("2017-11-01"));
    }

    @Test
    public void test02(){
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        System.out.println(month+"-"+day);
    }
}
