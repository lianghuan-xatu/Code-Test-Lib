package com.itheima;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String dateToString(Date date,String patt){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        String format1 = simpleDateFormat.format(date);
        return format1;
    }
    //字符串转换成日期
    public static Date StringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        Date parse = simpleDateFormat.parse(str);
        return parse;
    }

}
