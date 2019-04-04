package com.worknet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//공채속보 xml을 읽어 csv로 출력해주는 클래스 입니다
public class Gongsokxml2csv {

	

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\recruitsok\\공채속보1.xml"), "UTF-8");
		long st = System.currentTimeMillis();
		int c = 1;
		Pattern pt 
		= Pattern.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\-\\`\\~\\(\\)]");
		Pattern urlonly 
		= Pattern.compile("[\\,]");
		String cnt = doc.select("total").text();
		int num = Integer.parseInt(cnt)/100;
		System.out.println(num+2);
		
		String sb = "";
		
		String fsb = "";
		
		// csv 파일 만드는 코드
		sb+= "empseqno,empwantedtitle,empbusinm,coclcdnm,"
				+ "empwantedstdt,empwantedendt,empwantedtypenm,"
				+ "reglogimgnm,empwantedhomepgdetail,empwantedmobileurl\n";
		fsb+= "empseqno,empwantedtitle,empbusinm,coclcdnm,"
				+ "empwantedstdt,empwantedendt,empwantedtypenm,"
				+ "reglogimgnm,empwantedhomepgdetail,empwantedmobileurl\n";
		
		for(int i = 1 ; i<num+2 ;i++ ) {

			
			
			
			 Document docc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\recruitsok\\공채속보"
			 		+i+".xml"), "UTF-8");
			Elements e = docc.select("dhsOpenEmpInfo");
			for(Element eeee : e) {
				
				sb+=eeee.select("empseqno").text().trim() + ",";
				sb+=eeee.select("empwantedtitle").text().trim() + ",";
				sb+=eeee.select("empbusinm").text().trim() + ",";
				sb+=eeee.select("coclcdnm").text().trim() + ",";
				sb+=eeee.select("empwantedstdt").text().trim() + ",";
				sb+=eeee.select("empwantedendt").text().trim() + ",";
				sb+=eeee.select("empwantedtypenm").text().trim() + ",";
				sb+=eeee.select("reglogimgnm").text().trim() + ",";
				sb+=eeee.select("empwantedhomepgdetail").text().trim() + ",";
				sb+=eeee.select("empwantedmobileurl").text().trim() + "\n";
				
				fsb+=pt.matcher(eeee.select("empseqno").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("empwantedtitle").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("empbusinm").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("coclcdnm").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("empwantedstdt").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("empwantedendt").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("empwantedtypenm").text().trim()).replaceAll("") + ",";
				fsb+=urlonly.matcher(eeee.select("reglogimgnm").text().trim()).replaceAll("") + ",";
				fsb+=urlonly.matcher(eeee.select("empwantedhomepgdetail").text().trim()).replaceAll("") + ",";
				fsb+=urlonly.matcher(eeee.select("empwantedmobileurl").text().trim()).replaceAll("") + "\n";
				
				c++;
				
			}
			//System.out.println(sb);
			
			
		}
		
		
		InputStream is 
		= new ByteArrayInputStream(sb.getBytes(StandardCharsets.UTF_8));
		FileOutputStream fos = new FileOutputStream("C:\\Webwork\\compathapi\\recruitsok\\공채속보.csv"); // csv
		//FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int r = 0;
		while((r=is.read())!=-1) {
			fos.write(r);
		}
		is.close();
		fos.close();
		
		InputStream iss 
		= new ByteArrayInputStream(fsb.getBytes(StandardCharsets.UTF_8));
		FileOutputStream foss = new FileOutputStream("C:\\\\Webwork\\\\compathapi\\\\recruitsok\\\\공채속보rep.csv"); // csv
		//FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int a = 0;
		while((a=iss.read())!=-1) {
			foss.write(a);
		}
		iss.close();
		foss.close();
		System.out.println(c);
		for(int j = 1 ; j<num+2 ;j++ ) {
			Gongdetailxml2csv.detailcsv(j);
		}
		long ed = System.currentTimeMillis();
		System.out.println(ed-st);
		
	}
}
