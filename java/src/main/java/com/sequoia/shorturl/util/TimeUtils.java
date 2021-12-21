package com.sequoia.shorturl.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/22
 */
public class TimeUtils {

    private static String INTERNATIONAL_TIME_PATTERN = "MMMMM-dd-yyyy hh:mm:ss";

    /**
     * 国际化时间
     * @return
     */
    public static String getNationalTime(Date date) {
        //Locale locale = new Locale("en-us", "US");
        Locale locale = new Locale("en");
        SimpleDateFormat dateFormat = new SimpleDateFormat(INTERNATIONAL_TIME_PATTERN, locale);

        return dateFormat.format(date);
    }

}
