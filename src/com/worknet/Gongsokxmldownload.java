package com.worknet;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
//공채속보 xml을 파싱해 출력하는 클래스입니다
public class Gongsokxmldownload {
	public static void main(String[] args) throws IOException {
		//공채속보 직업코드 없음 100개(최대값)
		Document doc = Jsoup.connect("http://openapi.work.go.kr/opi/opi/opia/dhsOpenEmpInfoAPI.do?authKey=WNJSMP271GLDTVNDP06A72VR1HK&callTp=L&returnType=XML&startPage=1&display=100").get();
		
		String cnt = doc.select("total").text();
		int num = (Integer.parseInt(cnt)/100) + 1;
		
		//xml을 바로 파싱해서 전달하고 싶은때는 Jsoup.parse() 메소드를 이용한다
		//toString 으로 전달하면 태그 검색이 안됨
		
		for(int i =1 ;i<num+1 ;i++ ) {
			Document docc = Jsoup.connect("http://openapi.work.go.kr/opi/opi/opia/dhsOpenEmpInfoAPI.do?authKey=WNJSMP271GLDTVNDP06A72VR1HK&callTp=L&returnType=XML&startPage="
					+ i +"&display=100").get();
			String xml = docc.toString();
			
			InputStream is 
			= new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos = new FileOutputStream("C:\\Webwork\\compathapi\\recruitsok\\공채속보"+i+".xml");
			int r = 0;
			while((r=is.read())!=-1) {
				fos.write(r);
			}
			is.close();
			fos.close();
		
		}
		for(int j = 1 ;j<num+1 ;j++ ) {
		Gongdetailxmldownload.detailparser(j);
		}
	}
	
	
	
	
	
}
