package com.kami.mall.java.encryption;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.CommonException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * @author yangzi
 * @date 2021-07-08 5:16 PM
 */


public class EncryptUtils {
    public static String AES_KEY = "TaOXLwfQgDhFrqDC"; // AES 加解密使用的key，16位
    public static String NEW_AES_KEY = "YiOHCevaFPDhQxrK"; // AES 新的加解密使用的key，16位
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 加密
     * @param plainPassword
     * @return
     */
    public static String encryptPassword(String plainPassword) {
        byte[] x = EncryptUtils.aesEncrypt(plainPassword, AES_KEY);
        return new String(x);
    }

    /**
     * 解密
     * @param encryptedPassword
     * @return
     */
    public static String decryptPassword(String encryptedPassword) {
        byte[] y = EncryptUtils.aesDecrypt(encryptedPassword.getBytes(), AES_KEY.getBytes());
        return new String(y);
    }

    /**
     * 新加密
     * @param plainPassword
     * @return
     */
    public static String newEncryptPassword(String plainPassword) {
        byte[] x = EncryptUtils.aesEncrypt(plainPassword, NEW_AES_KEY);
        return new String(x);
    }

    /**
     * 新解密
     * @param encryptedPassword
     * @return
     */
    public static String newDecryptPassword(String encryptedPassword) {
        byte[] y = EncryptUtils.aesDecrypt(encryptedPassword.getBytes(), NEW_AES_KEY.getBytes());
        return new String(y);
    }

    public static String MD5_16(String data) {
        return MD5_16(data.getBytes());
    }

    public static String MD5_16(byte[] data) {
        return MD5(data).substring(8, 24);
    }

    public static String MD5(String data) {
        return MD5(data.getBytes());
    }

    public static String MD5(byte[] data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data);
            return new BigInteger(messageDigest.digest()).toString(16).toUpperCase();
        } catch (Exception e) {
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "encrypt error.", e);
        }
    }

    /**
     * md5加密
     * @param paramSrc
     * @return
     */
    public static String md5(String paramSrc) {
        try {
            byte[] btInput = paramSrc.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = HEX_DIGITS[byte0 >>> 4 & 0xf];
                str[k++] = HEX_DIGITS[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "encrypt error.", e);
        }
    }

    public static byte[] aesEncrypt(String data, String key) {
        return aesEncrypt(data.getBytes(), key.getBytes());
    }

    public static byte[] aesEncrypt(byte[] data, byte[] key) {
        try {
            String iv = EncryptUtils.MD5_16(key);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            int plaintextLength = data.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(data, 0, plaintext, 0, data.length);

            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return Base64.getEncoder().encode(encrypted);
        } catch (Exception e) {
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "encrypt error.", e);
        }
    }

    public static byte[] aesDecrypt(String data, String key) {
        return aesDecrypt(data.getBytes(), key.getBytes());
    }

    public static byte[] aesDecrypt(byte[] data, byte[] key) {
        try {
            String iv = EncryptUtils.MD5_16(key);

            byte[] encrypted = Base64.getDecoder().decode(data);

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

    /**
     * AES解密
     * @param data
     * @param key
     * @return
     */
    public static byte[] aesDecrypt(byte[] data, String key) {
        try {
            String newKey = key.substring(0, 16);
            String iv = EncryptUtils.md5(newKey).substring(0,16);

            byte[] encrypted = Base64.getDecoder().decode(data);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(newKey.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

            return removieZeroSuffix(cipher.doFinal(encrypted));
        } catch (Exception e) {
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "encrypt error.", e);
        }
    }
}

