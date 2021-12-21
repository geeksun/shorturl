package com.sequoia.shorturl;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/22
 */
public class I18NTester {

    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);
        System.out.println(dateFormat.format(new Date()));
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        System.out.println(dateFormat.format(new Date()));
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        System.out.println(dateFormat.format(new Date()));
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        System.out.println(dateFormat.format(new Date())); }


}
