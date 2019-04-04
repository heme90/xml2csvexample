package com.news;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Datetest {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		SimpleDateFormat sm = new SimpleDateFormat("YYYYMMdd");
		calendar.add(Calendar.MONTH, -2);
	    String strDate = sm.format(calendar.getTime());
	   
	    
	  
	}

}
