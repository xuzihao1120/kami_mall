package com.kami.mall.java.comons.Utils;

import com.kami.mall.common.model.CommonErrorCode;
import com.kami.mall.common.model.CommonException;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author yangzi
 * @date 2021-07-08 7:58 PM
 */
public class AESUtils {

    public static String AES_KEY = "TaOXLwfQgDhFrqDC"; // AES 加解密使用的key，16位
    private static final String KEY_GEN = "AES/ECB/PKCS5Padding";
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(AESUtils.class);

    /**
     * 加密
     *
     * @param content    加密的字符串
     * @return
     * @throws Exception
     */
    public static String encrypt(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance(KEY_GEN);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(AES_KEY.getBytes(), "AES"));
            byte[] b = cipher.doFinal(content.getBytes("utf-8"));
            return Base64Utils.encodeToString(b);
        } catch (Exception e) {
            logger.error("AES加密操作异常", e);
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "encrypt error.", e);
        }
    }

    /**
     * 解密
     *
     * @param encryptStr 解密的字符串
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptStr) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance(KEY_GEN);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(AES_KEY.getBytes(), "AES"));
            byte[] encryptBytes = Base64Utils.decodeFromString(encryptStr);
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            return new String(decryptBytes);
        } catch (Exception e) {
            logger.error("AES解密操作异常", e);
            throw new CommonException(CommonErrorCode.UNKNOWN_ERROR, "decrypt error.", e);
        }
    }
}
