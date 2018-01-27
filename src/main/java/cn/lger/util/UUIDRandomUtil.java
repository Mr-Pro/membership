package cn.lger.util;

import java.util.UUID;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-15.
 */
public class UUIDRandomUtil {

    public static String get32UUID() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }

}
