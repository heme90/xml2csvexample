package com.news;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewsTest {
	public static void main(String[] args) throws IOException {
		
		// 원하는 뉴스 주소 입력
		Document doc 
		= Jsoup.connect("https://news.naver.com/main/ranking/read.nhn?mid=etc&sid1=111&rankingType=popular_day&oid=353&aid=0000033691&date=20190330&type=1&rankingSeq=6&rankingSectionId=102").get();
		
		// 뉴스의 본문이 들어가는 id
		
		Elements e = doc.select("#articleBodyContents");
		
		/* e.filter();*/
		
		String html = e.toString();
		System.out.println(html);
		/*InputStream is //글자 깨지면 인코딩 확인
		= new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
		//출력위치
		FileOutputStream fos = new FileOutputStream("newswithtag3.txt");
		int r = 0;
		while((r=is.read())!=-1) {
			fos.write(r);
		}
		is.close();
		fos.close();*/
		
		
	}
}
