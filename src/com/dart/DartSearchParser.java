package com.dart;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DartSearchParser {
	public static void main(String[] args) throws IOException {
		//http://dart.fss.or.kr/api/search.xml?auth=c3e9f90c0a5369c038ee7cdf4e717c698c89f303&page_set=100&page_no=1
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
		SimpleDateFormat sm = new SimpleDateFormat("YYYYMMdd");
		calendar.add(Calendar.MONTH, -2);
	    String strDate = sm.format(calendar.getTime());
		
		
		String url = "http://dart.fss.or.kr/api/search.xml?auth="
				+ "c3e9f90c0a5369c038ee7cdf4e717c698c89f303&page_set=100&"
				+ "start_dt="+strDate
				+ "&dsp_tp=A&page_no=";
		Document doa = Jsoup.connect("http://dart.fss.or.kr/api/search.xml?auth=c3e9f90c0a5369c038ee7cdf4e717c698c89f303&dsp_tp=A&page_set=100"
				+ "&start_dt="+strDate).get();
		String num = doa.select("total_page").text();
		System.out.println(num);
		int cnt = Integer.parseInt(num);
		System.out.println(cnt);
		Document doc = null;
		
		for(int i = 1 ;i<=cnt ;i++ ) {
			String pageurl = url + i;
			try {
				doc = Jsoup.connect(pageurl).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String xml = doc.toString();

			InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos=null;
			try {
				fos = new FileOutputStream("C:\\Webwork\\compathapi\\dartsearch\\dart검색page" 
						+i+".xml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int r = 0;
			while ((r = is.read()) != -1) {
				fos.write(r);
			}
			is.close();
			fos.close();
		}
		
		
		Dartdetailparser.detailparser(cnt);
		

	}
}
