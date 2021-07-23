package com.kami.mall.java.comons.Utils;

import java.util.Random;

/**
 * @author yangzi
 * @date 2021-07-08 8:03 PM
 */
public class RandomUtils {

    public static final Random RANDOM = new Random();


    /**
     * 获取任意位随机数
     * @return
     */
    public static String getNum(int len) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(RANDOM.nextInt(10));
        }
        return stringBuilder.toString();
    }


}