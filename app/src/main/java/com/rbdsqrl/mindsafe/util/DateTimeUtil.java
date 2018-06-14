package com.rbdsqrl.mindsafe.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static String getCurrentDateFormatted(){
        SimpleDateFormat simpleDateFormat =   new SimpleDateFormat("dd MMM, yyyy");
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }
}
