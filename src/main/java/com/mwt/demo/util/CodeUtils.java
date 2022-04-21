package com.mwt.demo.util;

public class CodeUtils {

    /**
     * 不够位数补0
     *
     * @param str
     * @param strLength
     * @return
     */
    public static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    public static String createCode(String codeStartKey, int codeLength, int id, String codeEndKey) {
        String s = addZeroForNum(id + "", codeLength);
        return codeStartKey + s + codeEndKey;
    }
}
