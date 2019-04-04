package com.dart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Dartdetailparser {
	public static void detailparser(int cnt) throws IOException {	
		
		for(int i = 1 ;i<cnt+1 ;i++ ) {
			Document doc = null;
			doc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\dartsearch\\dart검색page"
					+ i +".xml"), "UTF-8");
			
			Elements nos = doc.select("crp_cd");
			for(String st : nos.eachText()) {
				String url = "http://dart.fss.or.kr/api/company.xml?auth="
						+ "c3e9f90c0a5369c038ee7cdf4e717c698c89f303&crp_cd="
						+st;
				
				Document docc = Jsoup.connect(url).get();
				String xml = docc.toString();

				InputStream is = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
				FileOutputStream fos=null;
				try {
					fos = new FileOutputStream("C:\\Webwork\\compathapi\\dartdetail\\dart상세" 
							+st+".xml");
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
			
			
			
		}
	}
}
