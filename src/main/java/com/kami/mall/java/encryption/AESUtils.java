package com.kami.mall.java.encryption;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.CommonException;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author yangzi
 * @date 2021-07-06 4:41 PM
 */
public class AESUtils {

    // 密匙，随意字符串
    private static final String key = "12345678901234567890123456789012";
    // iv偏移量，随意字符串
    private static final String iv = "1234567890123456";

    /**
     * 加密：对字符串进行加密，获得十六进制bytes，再由Base64算法转码成字符串
     * @param str
     * @return 加密后的字符串
     */
    public static String encrypt(String str) {
        try {
            // 1、配置密匙和偏移量参数
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));

            // 2、初始化加密算法
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

            // 3、执行AES加密string转bytes
            byte[] encryted = cipher.doFinal(str.getBytes());

            // 4、使用Base64算法做转码、同时还能起到2次加密的作用
            return Base64.encodeBase64String(encryted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 解密：对加密后的字符串进行解密，并返回字符串
     * @param str 需要解密的，加密后的字符串
     * @return 解密后的字符串
     */
    public static String decrypt(String str) {
        try {
            // 1.配置密匙和偏移量参数（必须和加密时相同）
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            // 2.初始化加密算法
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);

            // 3.使用Base64算法做解码，获得bytes数据
            byte[] bytes = Base64.decodeBase64(str);

            // 4.执行AES解密
            byte[] original = cipher.doFinal(bytes);

            // 5.返回字节码对应的字符串
            return new String(original);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] aesDecrypt(byte[] data, byte[] key) {
        try {
            String iv = EncryptUtils.MD5_16(key);

            byte[] encrypted = java.util.Base64.getDecoder().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            return removieZeroSuffix(cipher.doFinal(encrypted));
        } catch (Exception e) {
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "aesDecrypt error.", e);
        }
    }

    public static byte[] removieZeroSuffix(byte[] arr) {
        int idxEnd;
        for(idxEnd = arr.length; idxEnd > 0; -- idxEnd) {
            if(arr[idxEnd - 1] == 0) {
                continue;
            }
            break;
        }
        if(idxEnd == arr.length) {
            return arr;
        }
        byte[] dest = new byte[idxEnd];
        System.arraycopy(arr, 0, dest, 0, idxEnd);
        return dest;
    }


}
