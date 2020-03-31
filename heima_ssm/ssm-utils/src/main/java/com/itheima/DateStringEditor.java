package com.itheima;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.beans.PropertyEditor;
import java.text.ParseException;
import java.util.Date;

/**
 * 日期与字符串转换
 */
public class DateStringEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
           Date date= DateUtils.StringToDate(text,"yyyy-MM-dd HH:mm");
           super.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
