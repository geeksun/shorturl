package com.sequoia.shorturl.tcp.refactor;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/3
 */
public class Utils {

    // int数值转为字节数组
    public static byte[] int2Bytes(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) (i >> 24 & 0xFF);
        result[1] = (byte) (i >> 16 & 0xFF);
        result[2] = (byte) (i >> 8 & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    //字节数组转为int数值
    public static int bytes2Int(byte[] bytes){
        int num = bytes[3] & 0xFF;
        num |= ((bytes[2] << 8) & 0xFF00);
        num |= ((bytes[1] << 16) & 0xFF0000);
        num |= ((bytes[0] << 24)  & 0xFF000000);
        return num;
    }

}
