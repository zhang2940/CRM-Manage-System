package com.crm.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/*
 * 完成时间日期字符串想时间类型转换
 * 实现了Converter接口
 */
public class DateConvert implements Converter<String, Timestamp>{

	private String pattern;

	
	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	@Override
	public Timestamp convert(String source) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date  timeDate = null;
 
        try {
        	 timeDate = format.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Timestamp dateTime = new Timestamp(timeDate.getTime());
        return dateTime;
	}

}
