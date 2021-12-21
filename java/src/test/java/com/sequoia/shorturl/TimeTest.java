package com.sequoia.shorturl;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/22
 */
public class TimeTest {

    @Test
    public void test(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-12:00"));
        //设置GMT东8区时区，即北京时间

        System.out.println(sdf.format(new Date()));


    }

    @Test
    public void test2() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
        String str1 = d1.format(now);
        DateFormat d2 = DateFormat.getDateTimeInstance();//获取系统时间格式
        String str2 = d2.format(now); //将时间格式转换成字符串
        DateFormat d3 = DateFormat.getTimeInstance();
        String str3 = d3.format(now);
        DateFormat d4 = DateFormat.getInstance(); //使用SHORT风格显示日期和时间
        String str4 = d4.format(now);
        DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
        String str5 = d5.format(now);
        DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
        String str6 = d6.format(now);
        DateFormat d7 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，时间（精确到分）
        String str7 = d7.format(now);
        DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
        String str8 = d8.format(now);//与SHORT风格相比，这种方式最好用
        System.out.println("用Date方式显示时间: " + now);//此方法显示的结果和Calendar.getInstance().getTime()一样
        System.out.println("用DateFormat.getDateInstance()格式化时间后为：" + str1);
        System.out.println("用DateFormat.getDateTimeInstance()格式化时间后为：" + str2);
        System.out.println("用DateFormat.getTimeInstance()格式化时间后为：" + str3);
        System.out.println("用DateFormat.getInstance()格式化时间后为：" + str4);
        System.out.println("用DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL)格式化时间后为：" + str5);
        System.out.println("用DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG)格式化时间后为：" + str6);
        System.out.println("用DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT)格式化时间后为：" + str7);
        System.out.println("用DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM)格式化时间后为：" + str8);
    }

    /**
     * 国际化时间设置
     */
    @Test
    public void test3(){
        System.out.println(Locale.getDefault());

        //Locale locale = new Locale("en-us", "US");
        //String pattern = "EEEEE MMMMM yyyy";

        Locale locale = new Locale("en-us");
        String pattern = "MMMMM-dd-yyyy hh:mm:ss";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();

        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));

        simpleDateFormat = new SimpleDateFormat(pattern,locale);

        System.out.println(simpleDateFormat.format(date));

        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.US);
        System.out.println(sdf.format(date));


    }

}
