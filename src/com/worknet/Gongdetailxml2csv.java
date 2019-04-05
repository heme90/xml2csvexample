package com.worknet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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
		// &amp \&amp
		/*
		 * \&nbsp; ” ” : 공백(스페이스 한 칸)을 의미
		 * 
		 * \&lt; 부등호(<)
		 * 
		 * \&gt; 부등호(>)
		 * 
		 * \&amp; 앰퍼샌드(&) 기호
		 * 
		 * \&quot; 쌍따옴표(“)
		 * 
		 * \&#035; sharp(#)
		 * 
		 * \&#039; 따옴표(‘)
		 */
		Pattern pt = Pattern.compile(
				"[\\&#039;\\&#035;\\&quot;\\&gt;\\&lt;\\&amp;\\=\\<\\>\\，\\/\\,\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\-\\`\\~\\(\\)]");
		Pattern urlonly = Pattern.compile("[\\，\\,]");

		try {
			doc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\recruitsok\\공채속보" + page + ".xml"), "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements e = doc.select("empSeqno");
		String sb = "";
		String fsb = "";
		/*
		 * sb += "empSeqno,empWantedTitle,empBusiNm,coClcdNm," +
		 * "empWantedStdt,empWantedEndt,empWantedHomepg,empWantedHomepgDetail," +
		 * "regLogImgNm,empWantedTypeNm,selfintroQstCont1," +
		 * "selfintroQstCont2,selfintroQstCont3," +
		 * "selsNm1,selsSchdCont1,selsCont1,selsMemoCont1," +
		 * "selsNm2,selsSchdCont2,selsCont2,selsMemoCont2," +
		 * "selsNm3,selsSchdCont3,selsCont3,selsMemoCont3," +
		 * "selsNm4,selsSchdCont4,selsCont4,selsMemoCont4," +
		 * "selsNm5,selsSchdCont5,selsCont5,selsMemoCont5," +
		 * "selsNm6,selsSchdCont6,selsCont6,selsMemoCont6," +
		 * "selsNm7,selsSchdCont7,selsCont7,selsMemoCont7," +
		 * "empRecrNm1,jobCont1,empWantedCareerNm1,empWantedEduNm1,sptCertEtc1,recrPsncnt1,empRecrMemoCont1,workRegionNm1,"
		 * +
		 * "empRecrNm2,jobCont2,empWantedCareerNm2,empWantedEduNm2,sptCertEtc2,recrPsncnt2,empRecrMemoCont2,workRegionNm2,"
		 * +
		 * "empRecrNm3,jobCont3,empWantedCareerNm3,empWantedEduNm3,sptCertEtc3,recrPsncnt3,empRecrMemoCont3,workRegionNm3,"
		 * +
		 * "empRecrNm4,jobCont4,empWantedCareerNm4,empWantedEduNm4,sptCertEtc4,recrPsncnt4,empRecrMemoCont4,workRegionNm4,"
		 * +
		 * "empRecrNm5,jobCont5,empWantedCareerNm5,empWantedEduNm5,sptCertEtc5,recrPsncnt5,empRecrMemoCont5,workRegionNm5,"
		 * +
		 * "empRecrNm6,jobCont6,empWantedCareerNm6,empWantedEduNm6,sptCertEtc6,recrPsncnt6,empRecrMemoCont6,workRegionNm6,"
		 * +
		 * "empRecrNm7,jobCont7,empWantedCareerNm7,empWantedEduNm7,sptCertEtc7,recrPsncnt7,empRecrMemoCont7,workRegionNm7,"
		 * +
		 * "empRecrNm8,jobCont8,empWantedCareerNm8,empWantedEduNm8,sptCertEtc8,recrPsncnt8,empRecrMemoCont8,workRegionNm8,"
		 * +
		 * "empRecrNm9,jobCont9,empWantedCareerNm9,empWantedEduNm9,sptCertEtc9,recrPsncnt9,empRecrMemoCont9,workRegionNm9,"
		 * +
		 * "empRecrNm10,jobCont10,empWantedCareerNm10,empWantedEduNm10,sptCertEtc10,recrPsncnt10,empRecrMemoCont10,workRegionNm10,"
		 * +
		 * "empRecrNm11,jobCont11,empWantedCareerNm11,empWantedEduNm11,sptCertEtc11,recrPsncnt11,empRecrMemoCont11,workRegionNm11,"
		 * +
		 * "empRecrNm12,jobCont12,empWantedCareerNm12,empWantedEduNm12,sptCertEtc12,recrPsncnt12,empRecrMemoCont12,workRegionNm12,"
		 * +
		 * "empRecrNm13,jobCont13,empWantedCareerNm13,empWantedEduNm13,sptCertEtc13,recrPsncnt13,empRecrMemoCont13,workRegionNm13,"
		 * +
		 * "empRecrNm14,jobCont14,empWantedCareerNm14,empWantedEduNm14,sptCertEtc14,recrPsncnt14,empRecrMemoCont14,workRegionNm14,"
		 * +
		 * "empRecrNm15,jobCont15,empWantedCareerNm15,empWantedEduNm15,sptCertEtc15,recrPsncnt15,empRecrMemoCont15,workRegionNm15,"
		 * +
		 * "empRecrNm16,jobCont16,empWantedCareerNm16,empWantedEduNm16,sptCertEtc16,recrPsncnt16,empRecrMemoCont16,workRegionNm16,"
		 * +
		 * "empRecrNm17,jobCont17,empWantedCareerNm17,empWantedEduNm17,sptCertEtc17,recrPsncnt17,empRecrMemoCont17,workRegionNm17,"
		 * +
		 * "empRecrNm18,jobCont18,empWantedCareerNm18,empWantedEduNm18,sptCertEtc18,recrPsncnt18,empRecrMemoCont18,workRegionNm18,"
		 * +
		 * "empRecrNm19,jobCont19,empWantedCareerNm19,empWantedEduNm19,sptCertEtc19,recrPsncnt19,empRecrMemoCont19,workRegionNm19,"
		 * +
		 * "empRecrNm20,jobCont20,empWantedCareerNm20,empWantedEduNm20,sptCertEtc20,recrPsncnt20,empRecrMemoCont20,workRegionNm20,"
		 * + "jobsCd1,jobsCdKorNm1,jobsCd2,jobsCdKorNm2,jobsCd3,jobsCdKorNm3," +
		 * "jobsCd4,jobsCdKorNm4,jobsCd5,jobsCdKorNm5," +
		 * "recrCommCont,inqryCont,empnEtcCont\n";
		 * 
		 * fsb += "empSeqno,empWantedTitle,empBusiNm,coClcdNm," +
		 * "empWantedStdt,empWantedEndt,empWantedHomepg,empWantedHomepgDetail," +
		 * "regLogImgNm,empWantedTypeNm,selfintroQstCont1," +
		 * "selfintroQstCont2,selfintroQstCont3," +
		 * "selsNm1,selsSchdCont1,selsCont1,selsMemoCont1," +
		 * "selsNm2,selsSchdCont2,selsCont2,selsMemoCont2," +
		 * "selsNm3,selsSchdCont3,selsCont3,selsMemoCont3," +
		 * "selsNm4,selsSchdCont4,selsCont4,selsMemoCont4," +
		 * "selsNm5,selsSchdCont5,selsCont5,selsMemoCont5," +
		 * "selsNm6,selsSchdCont6,selsCont6,selsMemoCont6," +
		 * "selsNm7,selsSchdCont7,selsCont7,selsMemoCont7," +
		 * "empRecrNm1,jobCont1,empWantedCareerNm1,empWantedEduNm1,sptCertEtc1,recrPsncnt1,empRecrMemoCont1,workRegionNm1,"
		 * +
		 * "empRecrNm2,jobCont2,empWantedCareerNm2,empWantedEduNm2,sptCertEtc2,recrPsncnt2,empRecrMemoCont2,workRegionNm2,"
		 * +
		 * "empRecrNm3,jobCont3,empWantedCareerNm3,empWantedEduNm3,sptCertEtc3,recrPsncnt3,empRecrMemoCont3,workRegionNm3,"
		 * +
		 * "empRecrNm4,jobCont4,empWantedCareerNm4,empWantedEduNm4,sptCertEtc4,recrPsncnt4,empRecrMemoCont4,workRegionNm4,"
		 * +
		 * "empRecrNm5,jobCont5,empWantedCareerNm5,empWantedEduNm5,sptCertEtc5,recrPsncnt5,empRecrMemoCont5,workRegionNm5,"
		 * +
		 * "empRecrNm6,jobCont6,empWantedCareerNm6,empWantedEduNm6,sptCertEtc6,recrPsncnt6,empRecrMemoCont6,workRegionNm6,"
		 * +
		 * "empRecrNm7,jobCont7,empWantedCareerNm7,empWantedEduNm7,sptCertEtc7,recrPsncnt7,empRecrMemoCont7,workRegionNm7,"
		 * +
		 * "empRecrNm8,jobCont8,empWantedCareerNm8,empWantedEduNm8,sptCertEtc8,recrPsncnt8,empRecrMemoCont8,workRegionNm8,"
		 * +
		 * "empRecrNm9,jobCont9,empWantedCareerNm9,empWantedEduNm9,sptCertEtc9,recrPsncnt9,empRecrMemoCont9,workRegionNm9,"
		 * +
		 * "empRecrNm10,jobCont10,empWantedCareerNm10,empWantedEduNm10,sptCertEtc10,recrPsncnt10,empRecrMemoCont10,workRegionNm10,"
		 * +
		 * "empRecrNm11,jobCont11,empWantedCareerNm11,empWantedEduNm11,sptCertEtc11,recrPsncnt11,empRecrMemoCont11,workRegionNm11,"
		 * +
		 * "empRecrNm12,jobCont12,empWantedCareerNm12,empWantedEduNm12,sptCertEtc12,recrPsncnt12,empRecrMemoCont12,workRegionNm12,"
		 * +
		 * "empRecrNm13,jobCont13,empWantedCareerNm13,empWantedEduNm13,sptCertEtc13,recrPsncnt13,empRecrMemoCont13,workRegionNm13,"
		 * +
		 * "empRecrNm14,jobCont14,empWantedCareerNm14,empWantedEduNm14,sptCertEtc14,recrPsncnt14,empRecrMemoCont14,workRegionNm14,"
		 * +
		 * "empRecrNm15,jobCont15,empWantedCareerNm15,empWantedEduNm15,sptCertEtc15,recrPsncnt15,empRecrMemoCont15,workRegionNm15,"
		 * +
		 * "empRecrNm16,jobCont16,empWantedCareerNm16,empWantedEduNm16,sptCertEtc16,recrPsncnt16,empRecrMemoCont16,workRegionNm16,"
		 * +
		 * "empRecrNm17,jobCont17,empWantedCareerNm17,empWantedEduNm17,sptCertEtc17,recrPsncnt17,empRecrMemoCont17,workRegionNm17,"
		 * +
		 * "empRecrNm18,jobCont18,empWantedCareerNm18,empWantedEduNm18,sptCertEtc18,recrPsncnt18,empRecrMemoCont18,workRegionNm18,"
		 * +
		 * "empRecrNm19,jobCont19,empWantedCareerNm19,empWantedEduNm19,sptCertEtc19,recrPsncnt19,empRecrMemoCont19,workRegionNm19,"
		 * +
		 * "empRecrNm20,jobCont20,empWantedCareerNm20,empWantedEduNm20,sptCertEtc20,recrPsncnt20,empRecrMemoCont20,workRegionNm20,"
		 * + "jobsCd1,jobsCdKorNm1,jobsCd2,jobsCdKorNm2,jobsCd3,jobsCdKorNm3," +
		 * "jobsCd4,jobsCdKorNm4,jobsCd5,jobsCdKorNm5," +
		 * "recrCommCont,inqryCont,empnEtcCont\n";
		 */
		int cc = 0;
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
			/* System.out.println(ddoc.select("empWantedHomepg").text()); */
			sb += ddoc.select("empWantedHomepgDetail").text().trim() + ",";
			sb += ddoc.select("regLogImgNm").text().trim() + ",";
			sb += ddoc.select("empWantedTypeNm").text().trim() + ",";

			// ===================================================

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

			/* Elements selfintroQstCont = ddoc.select("empSelfintroList"); */
			// 4
			int qstcnt = 0;
			System.out.println("ddoc size :  " + ddoc.select("empSelsListInfo").size());
			for (Element QstCon : ddoc.select("empSelsList").select("empSelsListInfo")) {

				if (!QstCon.hasClass("selfintroQstCont")) {
					sb += QstCon.select("selfintroQstCont").text() + ",";
					fsb += pt.matcher(QstCon.select("selfintroQstCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}
				qstcnt += 1;
				if (qstcnt == 4) {
					System.out.println("full");
					break;

				}

				/*
				 * sb += QstCon.select("selfintroQstCont").text().trim(); fsb +=
				 * pt.matcher(QstCon.select("selfintroQstCont").text().trim()).replaceAll("") +
				 * ",";
				 */
			}
			if (4 - qstcnt > 0) {
				for (int q = 0; q < 4 - qstcnt; q++) {

					sb += ",";
					fsb += ",";
				}
			}

			// System.out.println(selslist);
			/* Elements sla = ddoc.select("empSelsListInfo"); */
			int empcnt = 0;
			for (Element list : ddoc.select("empSelsList").select("empSelsListInfo")) {

				/*
				 * sb += list.select("selsNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("selsNm").text().trim()).replaceAll("") + ","; sb +=
				 * list.select("selsSchdCont").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("selsSchdCont").text().trim()).replaceAll("") + ",";
				 * sb += list.select("selsCont").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("selsCont").text().trim()).replaceAll("") + ","; sb +=
				 * list.select("selsMemoCont").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("selsMemoCont").text().trim()).replaceAll("") + ",";
				 */
				if (!list.hasClass("selsNm")) {
					sb += list.select("selsNm").text() + ",";
					fsb += pt.matcher(list.select("selsNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}
				if (!list.hasClass("selsSchdCont")) {
					sb += list.select("selsSchdCont").text() + ",";
					fsb += pt.matcher(list.select("selsSchdCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}
				if (!list.hasClass("selsCont")) {
					sb += list.select("selsCont").text() + ",";
					fsb += pt.matcher(list.select("selsCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}
				if (!list.hasClass("selsMemoCont")) {
					sb += list.select("selsMemoCont").text() + ",";
					fsb += pt.matcher(list.select("selsMemoCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				empcnt += 1;
				if (empcnt == 7) {
					System.out.println("fffull");
					break;
				}
			}
			if (7 - empcnt > 0) {
				for (int i = 0; i < 7 - empcnt; i++) {
					sb += "," + "," + "," + ",";
					fsb += "," + "," + "," + ",";
				}
			}

			/* Elements slb = ddoc.select("empRecrListInfo"); */
			int reccnt = 0;
			for (Element list : ddoc.select("empRecrList").select("empRecrListInfo")) {

				/*
				 * sb += list.select("empRecrNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("empRecrNm").text().trim()).replaceAll("") + ","; sb
				 * += list.select("jobCont").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("jobCont").text().trim()).replaceAll("") + ","; sb +=
				 * list.select("empWantedCareerNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("empWantedCareerNm").text().trim()).replaceAll("") +
				 * ","; sb += list.select("empWantedEduNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("empWantedEduNm").text().trim()).replaceAll("") + ",";
				 * sb += list.select("sptCertEtc").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("sptCertEtc").text().trim()).replaceAll("") + ","; sb
				 * += list.select("recrPsncnt").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("recrPsncnt").text().trim()).replaceAll("") + ","; sb
				 * += list.select("empRecrMemoCont").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("empRecrMemoCont").text().trim()).replaceAll("") +
				 * ","; sb += list.select("workRegionNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("workRegionNm").text().trim()).replaceAll("") + ",";
				 */

				if (!list.hasClass("empRecrNm")) {
					sb += list.select("empRecrNm").text() + ",";
					fsb += pt.matcher(list.select("empRecrNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("jobCont")) {
					sb += list.select("jobCont").text() + ",";
					fsb += pt.matcher(list.select("jobCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("empWantedCareerNm")) {
					sb += list.select("empWantedCareerNm").text() + ",";
					fsb += pt.matcher(list.select("empWantedCareerNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("empWantedEduNm")) {
					sb += list.select("empWantedEduNm").text() + ",";
					fsb += pt.matcher(list.select("empWantedEduNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("sptCertEtc")) {
					sb += list.select("sptCertEtc").text() + ",";
					fsb += pt.matcher(list.select("sptCertEtc").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("recrPsncnt")) {
					sb += list.select("recrPsncnt").text() + ",";
					fsb += pt.matcher(list.select("recrPsncnt").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("empRecrempRecrMemoContNm")) {
					sb += list.select("empRecrMemoCont").text() + ",";
					fsb += pt.matcher(list.select("empRecrMemoCont").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				if (!list.hasClass("workRegionNm")) {
					sb += list.select("workRegionNm").text() + ",";
					fsb += pt.matcher(list.select("workRegionNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				reccnt += 1;
				if (reccnt == 20) {
					break;
				}

			}
			if (20 - reccnt > 0) {

				for (int j = 0; j < (20 - reccnt); j++) {
					sb += "," + "," + "," + "," + "," + "," + "," + ",";
					fsb += "," + "," + "," + "," + "," + "," + "," + ",";

				}
			}

			/*
			 * Elements slb = ddoc.select("empRecrListInfo"); int reccnt = 0; for (Element
			 * list : slb.select("empRecrListInfo")) {
			 */

			/* Elements slc = ddoc.select("empJobsListInfo"); */
			int jobcnt = 0;
			for (Element list : ddoc.select("empJobsListInfo")) {
				/*
				 * sb += list.select("jobsCd").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("jobsCd").text().trim()).replaceAll("") + ","; sb +=
				 * list.select("jobsCdKorNm").text().trim() + ","; fsb +=
				 * pt.matcher(list.select("jobsCdKorNm").text().trim()).replaceAll("") + ",";
				 */

				if (!list.hasClass("jobsCd")) {
					sb += list.select("jobsCd").text() + ",";
					fsb += pt.matcher(list.select("jobsCd").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}
				if (!list.hasClass("jobsCdKorNm")) {
					sb += list.select("jobsCdKorNm").text() + ",";
					fsb += pt.matcher(list.select("jobsCdKorNm").text()).replaceAll("") + ",";
				} else {
					sb += ",";
					fsb += ",";
				}

				jobcnt += 1;
				if (jobcnt == 5) {
					break;
				}

			}
			if (5 - jobcnt > 0) {
				for (int k = 0; k < 5 - jobcnt; k++) {
					sb += "," + ",";
					fsb += "," + ",";
				}
			}

			sb += ddoc.select("recrCommCont").text().trim() + ",";
			sb += ddoc.select("inqryCont").text().trim() + ",";
			sb += ddoc.select("empnEtcCont").text().trim() + "\n";

			fsb += pt.matcher(ddoc.select("recrCommCont").text().trim()).replaceAll("") + ",";
			fsb += urlonly.matcher(ddoc.select("inqryCont").text().trim()).replaceAll("") + ",";
			fsb += pt.matcher(ddoc.select("empnEtcCont").text().trim()).replaceAll("") + "\n";
			
			//System.out.println(fsb.split("\n")[cc].split(",").length);
			cc++;
		}
		String[] ress = fsb.split("\n"); 
		List<String> resl = new ArrayList<>();
		for(String a : ress) {
			resl.add(a);
		}
		
		for(int z=0 ; z < resl.size(); z++ ) {
			if((resl.get(z).split(",").length) < 214) {
				resl.remove(z);
			}
		}
		String res = "";
		for(int x = 0 ;x<resl.size() ;x++ ) {
			res += resl.get(x);
			System.out.println(resl.get(x).split(",").length);
		}
		
		InputStream is = new ByteArrayInputStream(sb.getBytes(StandardCharsets.UTF_8));
		FileOutputStream fos = new FileOutputStream(
				"C:\\Webwork\\compathapi\\recruitdetailcsv" + "\\공채상세csv" + page + ".csv"); // csv
		// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int bt = 0;
		while ((bt = is.read()) != -1) {
			fos.write(bt);
		}
		is.close();
		fos.close();

		InputStream iss = new ByteArrayInputStream(res.getBytes(StandardCharsets.UTF_8));
		FileOutputStream foss = new FileOutputStream(
				"C:\\Webwork\\compathapi\\recruitdetailcsvrep" + "\\공채상세csvrep" + page + ".csv"); // csv
		// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
		int btt = 0;
		while ((btt = iss.read()) != -1) {
			foss.write(btt);
		}
		iss.close();
		foss.close();

	}

}
