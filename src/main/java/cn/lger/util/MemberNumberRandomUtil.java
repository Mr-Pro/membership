package cn.lger.util;

import java.text.SimpleDateFormat;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-15.
 */
public class MemberNumberRandomUtil {

    public static SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmssSS");

    public synchronized static String randomMemberNumber(){
        return date.format(System.currentTimeMillis());
    }
}
