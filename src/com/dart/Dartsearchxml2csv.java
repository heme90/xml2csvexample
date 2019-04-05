package com.dart;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Dartsearchxml2csv {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\" + "dartsearch\\dart검색page1.xml"), "UTF-8");
		String cnt = doc.select("total_page").text();
		Pattern pt 
		= Pattern.compile("[\\&#039;\\&#035;\\&quot;\\&gt;\\&lt;\\&amp;\\=\\<\\>\\，\\/\\,\\\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\-\\`\\~\\(\\)]");
		
		System.out.println(cnt);
		int num = Integer.parseInt(cnt);
		for (int i = 1; i < num + 1; i++) {
			Document docc = Jsoup.parse(new File("C:\\Webwork\\compathapi\\" + "dartsearch\\dart검색page" + i + ".xml"),
					"UTF-8");
			String sb = "";
			String fsb = "";
			// csv 파일 만드는 코드
			sb += "crp_cls,crp_nm,crp_cd,rpt_nm,rcp_no,flr_nm,rcp_dt,rmk\n";
			fsb += "crp_cls,crp_nm,crp_cd,rpt_nm,rcp_no,flr_nm,rcp_dt,rmk\n";
			Elements e = docc.select("list");
			for (Element eeee : e) {
				sb += eeee.select("crp_cls").text().trim() + ",";
				sb += eeee.select("crp_nm").text().trim() + ",";
				sb += eeee.select("crp_cd").text().trim() + ",";
				sb += eeee.select("rpt_nm").text().trim() + ",";
				sb += eeee.select("rcp_no").text().trim() + ",";
				sb += eeee.select("flr_nm").text().trim() + ",";
				sb += eeee.select("rcp_dt").text().trim() + ",";
				sb += eeee.select("rmk").text() + "\n";
				
				
				fsb+=pt.matcher(eeee.select("crp_cls").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("crp_nm").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("crp_cd").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("rpt_nm").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("rcp_no").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("flr_nm").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("rcp_dt").text().trim()).replaceAll("") + ",";
				fsb+=pt.matcher(eeee.select("rmk").text()).replaceAll("") + "\n";
				

			}
			System.out.println(sb);

			InputStream is = new ByteArrayInputStream(sb.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos = new FileOutputStream(
					"C:\\Webwork\\compathapi\\dartsearchcsv\\" + "dartsearchdetailpage" + i + ".csv"); // csv
			// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
			int r = 0;
			while ((r = is.read()) != -1) {
				fos.write(r);
			}
			is.close();
			fos.close();
			
			InputStream is2 = new ByteArrayInputStream(fsb.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fos2 = new FileOutputStream(
					"C:\\Webwork\\compathapi\\dartsearchcsvrep\\" + "dartsearchdetailpagerep" + i + ".csv"); // csv
			// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
			int rr = 0;
			while ((rr = is2.read()) != -1) {
				fos2.write(rr);
			}
			is2.close();
			fos2.close();
			
			
			String ssb = "";
			String ssbb = "";
			ssb += "crp_nm,crp_nm_e,crp_nm_i,stock_cd,ceo_nm,crp_cls,crp_no,bsn_no,"
					+ "adr,hm_url,ir_url,phn_no,fax_no,ind_cd,est_dt,acc_mt\n";
			ssbb += "crp_nm,crp_nm_e,crp_nm_i,stock_cd,ceo_nm,crp_cls,crp_no,bsn_no,"
					+ "adr,hm_url,ir_url,phn_no,fax_no,ind_cd,est_dt,acc_mt\n";
	
			Elements nos = docc.select("crp_cd");
			for (String st : nos.eachText()) {
				ssb += Dartdetailxml2csv.detail2csv(st)+"\n";
				
				ssbb+=Dartdetailxml2csv.detail2csvrep(st) + "\n";
			}

			InputStream iss = new ByteArrayInputStream(ssb.getBytes(StandardCharsets.UTF_8));
			FileOutputStream foss = new FileOutputStream(
					"C:\\Webwork\\compathapi\\dartdetailcsv\\" + "dartdatailcsv" + i + ".csv"); // csv
			// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
			int a = 0;
			while ((a = iss.read()) != -1) {
				foss.write(a);
			}
			iss.close();
			foss.close();
			
			InputStream issr = new ByteArrayInputStream(ssbb.getBytes(StandardCharsets.UTF_8));
			FileOutputStream fossr = new FileOutputStream(
					"C:\\Webwork\\compathapi\\dartdetailcsvrep\\" + "dartdatailcsvrep" + i + ".csv"); // csv
			// FileOutputStream fos = new FileOutputStream("공채속보.xlxs"); 엑셀파일
			int ar = 0;
			while ((ar = issr.read()) != -1) {
				fossr.write(ar);
			}
			issr.close();
			fossr.close();

			
			

		}

	}

}
