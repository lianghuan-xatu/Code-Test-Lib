package com.itcast.utils;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(source==null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        //将字符串转换成日期
        try {
             parse = df.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
