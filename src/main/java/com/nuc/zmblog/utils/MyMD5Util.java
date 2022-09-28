package com.nuc.zmblog.utils;


import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * MD5加密工具类
 *
 */
public class MyMD5Util {
    //盐，用于混交md5
    private static final String slat = "132312";

    /**
     * 1.java原生用法
     *
     * @return String
     */
    public static String encrypt(String dataStr) {
        try {
            dataStr = dataStr + slat;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(dataStr.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (byte b : s) {
                result.append(Integer.toHexString((0x000000FF & b) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 2.spring提供的工具类用法
     * 生成md5
     *
     * @return
     */
    public static String getMD5(String str) {
        String base = str + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


    public static void main(String[] args) {
        System.out.println(encrypt("123456"));
    }
}


