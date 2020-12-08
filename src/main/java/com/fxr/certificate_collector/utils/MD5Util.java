package com.fxr.certificate_collector.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** MD5加密类
 * @author fanXiaoRui
 * @date 2020/11/17 16:32
 */
public class MD5Util {

    /** 小程序账号: admin-fxr、admin-hwj、admin-wyq
     *  小程序密码：wamsb
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }


    public static void main(String[] args) {
        System.out.println(code("wamsb"));
    }

}
