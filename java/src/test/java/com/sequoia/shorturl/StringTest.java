package com.sequoia.shorturl;

import com.alibaba.fastjson.JSON;
import com.sequoia.shorturl.po.User;
import com.sequoia.shorturl.util.MailUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class StringTest {

    /**
     * 中文字符转码
     */
    @Ignore
    @Test
    public void encode() {
        String str = "测试字符转换 a beautiful girl"; //默认环境，已是UTF-8编码
        str = "BUY10000000649903B款 枪弹分离男士内裤/goods/item.jhtml?id=21any";
        try {
            String strGBK = URLEncoder.encode(str, "UTF-8");
            System.out.println(strGBK);
            String strUTF8 = URLDecoder.decode(str, "UTF-8");
            System.out.println(strUTF8);

            String str2 = URLDecoder.decode("03B%E6%AC%BE%20%E6%9E%AA%E5%BC%B9%E5%88%86%E7%A6%BB%E7%94%B7%E5%A3%AB%E5%86%85%E8%A3%A4",
                    "UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Ignore
    @Test
    public void calculate() {
        double a = 0.01;
        double b = 1.00;
        double c = a+b;
        System.out.println(c);
    }

    @Test
    public void error() {
        try {
            String s = null;
            if(s.contains("2")) {
                System.out.println("ok");
            }
        } catch (Exception e) {
            System.out.println("error ==> ");
            //System.out.println(e.getCause().getMessage());
            //String message  = e.getCause().get;

            try {
                MailUtil.warn(null, "test222", e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("----------------");
        }
    }

    @Test
    public void json() {

    }

    static void test() throws Exception {
        System.out.println("111");
        if(2>1) {
            throw new Exception("test err");
        }
        System.out.println(222);
    }

    static void test2() throws Exception {
        System.out.println("123");
        try {
            if(8>7){
                throw new RuntimeException("testok");
            }
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }

        System.out.println("7777");
        test();
        System.out.println("8888");
    }

    public static void main(String[] args) {
        try {
            test2();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for(int i=0;i<1;i++) {
            User loginUser = new User();
            loginUser.setId(910123493241l);
            loginUser.setName("testabc123456");
            loginUser.setAge(72);
            loginUser.setEmail("test_waveop@163.com");
            String str = JSON.toJSONString(loginUser);
            System.out.println(str);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

}
