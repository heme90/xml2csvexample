package com.worknet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
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
//공채상세 xml을 읽어 csv로 출력해주는 클래스입니다
public class Gongdetailxml2csv {
	public static void detailcsv(int page) throws IOException {
		Document doc = null;
		Pattern pt 
		= Pattern.compile("[\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\-\\`\\~\\(\\)]");
		Pattern urlonly 
		= Pattern.compile("[\\,]");
		
		try {
			doc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\recruitsok\\공채속보"
					+page+".xml"), "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements e = doc.select("empSeqno");
		String sb = "";
		String fsb = "";
		sb += "empSeqno,empWantedTitle,empBusiNm,coClcdNm,"
				+ "empWantedStdt,empWantedEndt,empWantedHomepg,empWantedHomepgDetail,"
				+ "regLogImgNm,empWantedTypeNm,selfintroQstCont1,"
				+ "selfintroQstCont2,selfintroQstCont3,"
				+ "selsNm1,selsSchdCont1,selsCont1,selsMemoCont1," + "selsNm2,selsSchdCont2,selsCont2,selsMemoCont2,"
				+ "selsNm3,selsSchdCont3,selsCont3,selsMemoCont3," + "selsNm4,selsSchdCont4,selsCont4,selsMemoCont4,"
				+ "selsNm5,selsSchdCont5,selsCont5,selsMemoCont5," + "selsNm6,selsSchdCont6,selsCont6,selsMemoCont6,"
				+ "selsNm7,selsSchdCont7,selsCont7,selsMemoCont7,"
				+ "empRecrNm1,jobCont1,empWantedCareerNm1,empWantedEduNm1,sptCertEtc1,recrPsncnt1,empRecrMemoCont1,workRegionNm1,"
				+ "empRecrNm2,jobCont2,empWantedCareerNm2,empWantedEduNm2,sptCertEtc2,recrPsncnt2,empRecrMemoCont2,workRegionNm2,"
				+ "empRecrNm3,jobCont3,empWantedCareerNm3,empWantedEduNm3,sptCertEtc3,recrPsncnt3,empRecrMemoCont3,workRegionNm3,"
				+ "empRecrNm4,jobCont4,empWantedCareerNm4,empWantedEduNm4,sptCertEtc4,recrPsncnt4,empRecrMemoCont4,workRegionNm4,"
				+ "empRecrNm5,jobCont5,empWantedCareerNm5,empWantedEduNm5,sptCertEtc5,recrPsncnt5,empRecrMemoCont5,workRegionNm5,"
				+ "empRecrNm6,jobCont6,empWantedCareerNm6,empWantedEduNm6,sptCertEtc6,recrPsncnt6,empRecrMemoCont6,workRegionNm6,"
				+ "empRecrNm7,jobCont7,empWantedCareerNm7,empWantedEduNm7,sptCertEtc7,recrPsncnt7,empRecrMemoCont7,workRegionNm7,"
				+ "empRecrNm8,jobCont8,empWantedCareerNm8,empWantedEduNm8,sptCertEtc8,recrPsncnt8,empRecrMemoCont8,workRegionNm8,"
				+ "empRecrNm9,jobCont9,empWantedCareerNm9,empWantedEduNm9,sptCertEtc9,recrPsncnt9,empRecrMemoCont9,workRegionNm9,"
				+ "empRecrNm10,jobCont10,empWantedCareerNm10,empWantedEduNm10,sptCertEtc10,recrPsncnt10,empRecrMemoCont10,workRegionNm10,"
				+ "empRecrNm11,jobCont11,empWantedCareerNm11,empWantedEduNm11,sptCertEtc11,recrPsncnt11,empRecrMemoCont11,workRegionNm11,"
				+ "empRecrNm12,jobCont12,empWantedCareerNm12,empWantedEduNm12,sptCertEtc12,recrPsncnt12,empRecrMemoCont12,workRegionNm12,"
				+ "empRecrNm13,jobCont13,empWantedCareerNm13,empWantedEduNm13,sptCertEtc13,recrPsncnt13,empRecrMemoCont13,workRegionNm13,"
				+ "empRecrNm14,jobCont14,empWantedCareerNm14,empWantedEduNm14,sptCertEtc14,recrPsncnt14,empRecrMemoCont14,workRegionNm14,"
				+ "empRecrNm15,jobCont15,empWantedCareerNm15,empWantedEduNm15,sptCertEtc15,recrPsncnt15,empRecrMemoCont15,workRegionNm15,"
				+ "empRecrNm16,jobCont16,empWantedCareerNm16,empWantedEduNm16,sptCertEtc16,recrPsncnt16,empRecrMemoCont16,workRegionNm16,"
				+ "empRecrNm17,jobCont17,empWantedCareerNm17,empWantedEduNm17,sptCertEtc17,recrPsncnt17,empRecrMemoCont17,workRegionNm17,"
				+ "empRecrNm18,jobCont18,empWantedCareerNm18,empWantedEduNm18,sptCertEtc18,recrPsncnt18,empRecrMemoCont18,workRegionNm18,"
				+ "empRecrNm19,jobCont19,empWantedCareerNm19,empWantedEduNm19,sptCertEtc19,recrPsncnt19,empRecrMemoCont19,workRegionNm19,"
				+ "empRecrNm20,jobCont20,empWantedCareerNm20,empWantedEduNm20,sptCertEtc20,recrPsncnt20,empRecrMemoCont20,workRegionNm20,"
				+ "jobsCd1,jobsCdKorNm1,jobsCd2,jobsCdKorNm2,jobsCd3,jobsCdKorNm3,"
				+ "jobsCd4,jobsCdKorNm4,jobsCd5,jobsCdKorNm5," + "recrCommCont,inqryCont,empnEtcCont\n";
		
		fsb += "empSeqno,empWantedTitle,empBusiNm,coClcdNm,"
				+ "empWantedStdt,empWantedEndt,empWantedHomepg,empWantedHomepgDetail,"
				+ "regLogImgNm,empWantedTypeNm,selfintroQstCont1,"
				+ "selfintroQstCont2,selfintroQstCont3,"
				+ "selsNm1,selsSchdCont1,selsCont1,selsMemoCont1," + "selsNm2,selsSchdCont2,selsCont2,selsMemoCont2,"
				+ "selsNm3,selsSchdCont3,selsCont3,selsMemoCont3," + "selsNm4,selsSchdCont4,selsCont4,selsMemoCont4,"
				+ "selsNm5,selsSchdCont5,selsCont5,selsMemoCont5," + "selsNm6,selsSchdCont6,selsCont6,selsMemoCont6,"
				+ "selsNm7,selsSchdCont7,selsCont7,selsMemoCont7,"
				+ "empRecrNm1,jobCont1,empWantedCareerNm1,empWantedEduNm1,sptCertEtc1,recrPsncnt1,empRecrMemoCont1,workRegionNm1,"
				+ "empRecrNm2,jobCont2,empWantedCareerNm2,empWantedEduNm2,sptCertEtc2,recrPsncnt2,empRecrMemoCont2,workRegionNm2,"
				+ "empRecrNm3,jobCont3,empWantedCareerNm3,empWantedEduNm3,sptCertEtc3,recrPsncnt3,empRecrMemoCont3,workRegionNm3,"
				+ "empRecrNm4,jobCont4,empWantedCareerNm4,empWantedEduNm4,sptCertEtc4,recrPsncnt4,empRecrMemoCont4,workRegionNm4,"
				+ "empRecrNm5,jobCont5,empWantedCareerNm5,empWantedEduNm5,sptCertEtc5,recrPsncnt5,empRecrMemoCont5,workRegionNm5,"
				+ "empRecrNm6,jobCont6,empWantedCareerNm6,empWantedEduNm6,sptCertEtc6,recrPsncnt6,empRecrMemoCont6,workRegionNm6,"
				+ "empRecrNm7,jobCont7,empWantedCareerNm7,empWantedEduNm7,sptCertEtc7,recrPsncnt7,empRecrMemoCont7,workRegionNm7,"
				+ "empRecrNm8,jobCont8,empWantedCareerNm8,empWantedEduNm8,sptCertEtc8,recrPsncnt8,empRecrMemoCont8,workRegionNm8,"
				+ "empRecrNm9,jobCont9,empWantedCareerNm9,empWantedEduNm9,sptCertEtc9,recrPsncnt9,empRecrMemoCont9,workRegionNm9,"
				+ "empRecrNm10,jobCont10,empWantedCareerNm10,empWantedEduNm10,sptCertEtc10,recrPsncnt10,empRecrMemoCont10,workRegionNm10,"
				+ "empRecrNm11,jobCont11,empWantedCareerNm11,empWantedEduNm11,sptCertEtc11,recrPsncnt11,empRecrMemoCont11,workRegionNm11,"
				+ "empRecrNm12,jobCont12,empWantedCareerNm12,empWantedEduNm12,sptCertEtc12,recrPsncnt12,empRecrMemoCont12,workRegionNm12,"
				+ "empRecrNm13,jobCont13,empWantedCareerNm13,empWantedEduNm13,sptCertEtc13,recrPsncnt13,empRecrMemoCont13,workRegionNm13,"
				+ "empRecrNm14,jobCont14,empWantedCareerNm14,empWantedEduNm14,sptCertEtc14,recrPsncnt14,empRecrMemoCont14,workRegionNm14,"
				+ "empRecrNm15,jobCont15,empWantedCareerNm15,empWantedEduNm15,sptCertEtc15,recrPsncnt15,empRecrMemoCont15,workRegionNm15,"
				+ "empRecrNm16,jobCont16,empWantedCareerNm16,empWantedEduNm16,sptCertEtc16,recrPsncnt16,empRecrMemoCont16,workRegionNm16,"
				+ "empRecrNm17,jobCont17,empWantedCareerNm17,empWantedEduNm17,sptCertEtc17,recrPsncnt17,empRecrMemoCont17,workRegionNm17,"
				+ "empRecrNm18,jobCont18,empWantedCareerNm18,empWantedEduNm18,sptCertEtc18,recrPsncnt18,empRecrMemoCont18,workRegionNm18,"
				+ "empRecrNm19,jobCont19,empWantedCareerNm19,empWantedEduNm19,sptCertEtc19,recrPsncnt19,empRecrMemoCont19,workRegionNm19,"
				+ "empRecrNm20,jobCont20,empWantedCareerNm20,empWantedEduNm20,sptCertEtc20,recrPsncnt20,empRecrMemoCont20,workRegionNm20,"
				+ "jobsCd1,jobsCdKorNm1,jobsCd2,jobsCdKorNm2,jobsCd3,jobsCdKorNm3,"
				+ "jobsCd4,jobsCdKorNm4,jobsCd5,jobsCdKorNm5," + "recrCommCont,inqryCont,empnEtcCont\n";
		

		for (String r : e.eachText()) {

			File fi = new File("C:\\Webwork\\compathapi\\recruitdetail\\공채상세" + r + ".xml");
			Document ddoc = null;
			try {
				ddoc = Jsoup.parse(fi, "UTF-8");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			sb += ddoc.select("empSeqno").text().trim() + ",";
			sb += ddoc.select("empWantedTitle").text().trim() + ",";
			sb += ddoc.select("empBusiNm").text().trim() + ",";
			sb += ddoc.select("coClcdNm").text().trim() + ",";
			sb += ddoc.select("empWantedStdt").text().trim() + ",";
			sb += ddoc.select("empWantedEndt").text().trim() + ",";
			sb += ddoc.select("empWantedHomepg").text().trim() + ",";
			/*System.out.println(ddoc.select("empWantedHomepg").text());*/
			sb += ddoc.select("empWantedHomepgDetail").text().trim() + ",";
			sb += ddoc.select("regLogImgNm").text().trim() + ",";
			sb += ddoc.select("empWantedTypeNm").text().trim() + ",";
			
			//===================================================
			
			fsb += pt.matcher(ddoc.select("empSeqno").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empWantedTitle").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empBusiNm").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("coClcdNm").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empWantedStdt").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empWantedEndt").text().trim()).replaceAll("") + ",";
			fsb += urlonly.matcher(ddoc.select("empWantedHomepg").text().trim()).replaceAll("") + ",";
			fsb += urlonly.matcher(ddoc.select("empWantedHomepgDetail").text().trim()).replaceAll("") + ",";
			fsb += urlonly.matcher(ddoc.select("regLogImgNm").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empWantedTypeNm").text().trim()).replaceAll("") + ",";
			
			
			
			
			
			Elements selfintroQstCont = ddoc.select("empSelfintroList");
			for (int i = 1; i <4 ; i++) {
				/*String se = selfintroQstCont.next().text();
				if (!se.isEmpty()) {
					sb += se + ",";
					fsb += pt.matcher(se).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}*/
				Elements asd =  selfintroQstCont.next();
				sb += asd.select("selfintroQstCont").text().trim();
				fsb += pt.matcher(asd.select("selfintroQstCont").text().trim()).replaceAll("") + ",";
				
			}
			Elements selslist = ddoc.select("empSelsListInfo");
			for (int i = 1; i < 8; i++) {
				Elements sl = selslist.next();
				/*if(!sl.select("selsNm").isEmpty()) {
					sb += sl.select("selsNm").text() + ",";
					fsb += pt.matcher(sl.select("selsNm").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}
				if(!sl.select("selsSchdCont").isEmpty()) {
					sb += sl.select("selsSchdCont").text() + ",";
					fsb += pt.matcher(sl.select("selsSchdCont").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}
				if(!sl.select("selsCont").isEmpty()) {
					sb += sl.select("selsCont").text() + ",";
					fsb += pt.matcher(sl.select("selsCont").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}
				if(!sl.select("selsMemoCont").isEmpty()) {
					sb += sl.select("selsMemoCont").text() + ",";
					fsb += pt.matcher(sl.select("selsMemoCont").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}*/
				sb += sl.select("selsNm").text().trim() + ",";
				fsb += pt.matcher(sl.select("selsNm").text().trim()).replaceAll("") + ",";
				sb += sl.select("selsSchdCont").text().trim() + ",";
				fsb += pt.matcher(sl.select("selsSchdCont").text().trim()).replaceAll("") + ",";
				sb += sl.select("selsCont").text().trim() + ",";
				fsb += pt.matcher(sl.select("selsCont").text().trim()).replaceAll("") + ",";
				sb += sl.select("selsMemoCont").text().trim() + ",";
				fsb += pt.matcher(sl.select("selsMemoCont").text().trim()).replaceAll("") + ",";
				
				
				
				
			}
			Elements recrlist = ddoc.select("empRecrListInfo");
			for (int i = 1; i < 21; i++) {
				Elements sl = recrlist.next();
				sb += sl.select("empRecrNm").text().trim() + ",";
				fsb += pt.matcher(sl.select("empRecrNm").text().trim()).replaceAll("") + ",";
				sb += sl.select("jobCont").text().trim() + ",";
				fsb += pt.matcher(sl.select("jobCont").text().trim()).replaceAll("") + ",";
				sb += sl.select("empWantedCareerNm").text().trim() + ",";
				fsb += pt.matcher(sl.select("empWantedCareerNm").text().trim()).replaceAll("") + ",";
				sb += sl.select("empWantedEduNm").text().trim() + ",";
				fsb += pt.matcher(sl.select("empWantedEduNm").text().trim()).replaceAll("") + ",";
				sb += sl.select("sptCertEtc").text().trim() + ",";
				fsb += pt.matcher(sl.select("sptCertEtc").text().trim()).replaceAll("") + ",";
				sb += sl.select("recrPsncnt").text().trim() + ",";
				fsb += pt.matcher(sl.select("recrPsncnt").text().trim()).replaceAll("") + ",";
				sb += sl.select("empRecrMemoCont").text().trim() + ",";
				fsb += pt.matcher(sl.select("empRecrMemoCont").text().trim()).replaceAll("") + ",";
				sb += sl.select("workRegionNm").text().trim() + ",";
				fsb += pt.matcher(sl.select("workRegionNm").text().trim()).replaceAll("") + ",";
				
				/*if(!sl.select("empRecrNm").isEmpty()) {
					sb += sl.select("empRecrNm").text() + ",";
					fsb += pt.matcher(sl.select("empRecrNm").text()).replaceAll("") + ",";1
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("jobCont").isEmpty()) {
					sb += sl.select("jobCont").text() + ",";
					fsb += pt.matcher(sl.select("jobCont").text()).replaceAll("") + ",";2
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("empWantedCareerNm").isEmpty()) {
					sb += sl.select("empWantedCareerNm").text() + ",";
					fsb += pt.matcher(sl.select("empWantedCareerNm").text()).replaceAll("") + ",";3
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("empWantedEduNm").isEmpty()) {
					sb += sl.select("empWantedEduNm").text() + ",";
					fsb += pt.matcher(sl.select("empWantedEduNm").text()).replaceAll("") + ",";4
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("sptCertEtc").isEmpty()) {
					sb += sl.select("sptCertEtc").text() + ",";
					fsb += pt.matcher(sl.select("sptCertEtc").text()).replaceAll("") + ",";5
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("recrPsncnt").isEmpty()) {
					sb += sl.select("recrPsncnt").text() + ",";
					fsb += pt.matcher(sl.select("recrPsncnt").text()).replaceAll("") + ",";6
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("empRecrempRecrMemoContNm").isEmpty()) {
					sb += sl.select("empRecrMemoCont").text() + ",";
					fsb += pt.matcher(sl.select("empRecrMemoCont").text()).replaceAll("") + ",";7
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!sl.select("workRegionNm").isEmpty()) {
					sb += sl.select("workRegionNm").text() + ",";
					fsb += pt.matcher(sl.select("workRegionNm").text()).replaceAll("") + ",";8
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
*/			
				
			
			
			}
			Elements jobcdinfo = ddoc.select("empJobListInfo");
			for (int i = 1; i < 6; i++) {
				Elements jl = jobcdinfo.next();
				sb += jl.select("jobsCd").text().trim() + ",";
				fsb += pt.matcher(jl.select("jobsCd").text().trim()).replaceAll("") + ",";
				sb += jl.select("jobsCdKorNm").text().trim() + ",";
				fsb += pt.matcher(jl.select("jobsCdKorNm").text().trim()).replaceAll("") + ",";
				
				/*if(!jl.select("jobsCd").isEmpty()) {
					sb += jl.select("jobsCd").text() + ",";
					fsb += pt.matcher(jl.select("jobsCd").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}
				//--------
				if(!jl.select("jobsCdKorNm").isEmpty()) {
					sb += jl.select("jobsCdKorNm").text() + ",";
					fsb += pt.matcher(jl.select("jobsCdKorNm").text()).replaceAll("") + ",";
				}else {
					sb += ",";
					fsb +=",";
				}*/
				//--------
			}
			sb += ddoc.select("recrCommCont").text().trim() + ",";
			sb += ddoc.select("inqryCont").text().trim() + ",";
			sb += ddoc.select("empnEtcCont").text().trim() + "\n";
			
			fsb += pt.matcher(ddoc.select("recrCommCont").text().trim()).replaceAll("") + ",";
			// 메일주소가 자주 들어갔음
			fsb += urlonly.matcher(ddoc.select("inqryCont").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empnEtcCont").text().trim()).replaceAll("") + "\n";

		}
		
		InputStream is = new ByteArrayInputStream(sb.getBytes(StandardCharsets.UTF_8));
		FileOutputStream fos = new FileOutputStream("C:\\Webwork\\compathapi\\recruitdetailcsv" 
				+ "\\공채상세csv"
				+page+".csv"); // csv
		// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int bt = 0;
		while ((bt = is.read()) != -1) {
			fos.write(bt);
		}
		is.close();
		fos.close();
		
		InputStream iss = new ByteArrayInputStream(fsb.getBytes(StandardCharsets.UTF_8));
		FileOutputStream foss = new FileOutputStream("C:\\Webwork\\compathapi\\recruitdetailcsvrep" 
				+ "\\공채상세csvrep"
				+page+".csv"); // csv
		// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int btt = 0;
		while ((btt = iss.read()) != -1) {
			foss.write(btt);
		}
		iss.close();
		foss.close();
		
		
	}
}
