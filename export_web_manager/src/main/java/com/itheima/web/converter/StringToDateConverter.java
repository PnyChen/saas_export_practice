package com.itheima.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        try {
            if (StringUtils.isEmpty(s)){
                return null;
            }
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
