package com.worknet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
//공채속보에 들어있는 empseqno를 읽어 공채상세 url에 요청한뒤 파싱해 저장하는
//클래스 입니다
public class Gongdetailxmldownload {
	public static void detailparser(int page) throws IOException {
		Document doc=null;
		try {
			doc = Jsoup.parse(
					new File("C:\\Webwork\\compathapi\\recruitsok\\공채속보"+page+".xml"),
					"UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements e = doc.select("empSeqno");
		for(String r : e.eachText()) {
			String url 
			= "http://openapi.work.go.kr/opi/opi/opia/dhsOpenEmpInfoAPI.do"
					+ "?authKey=WNJSMP271GLDTVNDP06A72VR1HK&returnType=XML"
					+ "&callTp=D&empSeqno="+r;
			Document docc=null;
			try {
				docc = Jsoup.connect(url).get();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String gdetail = docc.toString();
			
			InputStream is //글자 깨지면 인코딩 확인
			= new ByteArrayInputStream(gdetail.getBytes(StandardCharsets.UTF_8));
			//출력위치
			FileOutputStream fos 
			= new FileOutputStream("C:\\Webwork\\compathapi"
					+ "\\recruitdetail\\공채상세" + r + ".xml");
			int bt = 0;
			while((bt=is.read())!=-1) {
				fos.write(bt);
			}
			is.close();
			fos.close();
		
		}
		
		
		
	}
}
