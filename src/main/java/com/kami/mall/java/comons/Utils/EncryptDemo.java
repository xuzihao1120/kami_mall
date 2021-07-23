package com.kami.mall.java.comons.Utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author yangzi
 * @date 2021-07-08 7:59 PM
 */
public class EncryptDemo {

    public static void main(String[] args) {
        String str = "cs%//_xws1212   7758";
        String encrypt = AESUtils.encrypt(str);

        System.out.println("encrypt："  + encrypt);


        String decrypt = AESUtils.decrypt(encrypt);

        System.out.println("decrypt："  + decrypt);


        String token = System.currentTimeMillis() + "@" + 23 +  "@" + RandomUtils.getNum(10);
        System.out.println(token);


        Long aLong = Long.valueOf(StringUtils.substringBetween(token, "@", "@"));
        System.out.println(aLong);


    }
}
