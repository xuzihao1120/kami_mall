package com.kami.mall.java.encryption;

import java.nio.charset.StandardCharsets;

/**
 * @author yangzi
 * @date 2021-07-06 5:01 PM
 */
public class EncryDemo {

    public static String AES_KEY = "TaOXLwfQgDhFrqDC";

    public static void main(String[] args) {

//        String str = "[\"df\",\"-h\"]";
//
//        // 加密
//        String encrypt = AESUtils.encrypt(str);
//        System.out.println("加密前：" + encrypt);
//
//        // 解密
//        String decrypt = AESUtils.decrypt(encrypt);
//        System.out.println("解密后" + decrypt);


        byte[] bytes = AESUtils.aesDecrypt("0OZRQR2CeeYONY0T1ylXIg==".getBytes(StandardCharsets.UTF_8), AES_KEY.getBytes(StandardCharsets.UTF_8));

        System.out.println(new String(bytes));
    }


}
