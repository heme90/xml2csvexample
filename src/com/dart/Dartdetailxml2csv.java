package com.dart;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Dartdetailxml2csv {
	
	
	public static String detail2csv(String cnt) throws IOException {
		String sb = "";
		File fi = new File("C:\\Webwork\\compathapi\\dartdetail\\dart상세" + cnt + ".xml");
		Document ddoc = null;
		try {
			ddoc = Jsoup.parse(fi, "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * <?xml version="1.0" encoding="utf-8"?> <result> <err_code> 000 </err_code>
		 * <err_msg> 정상 </err_msg> <crp_nm> 동화약품(주) </crp_nm> <crp_nm_e> DONGWHA
		 * PHARM.CO.,LTD </crp_nm_e> <crp_nm_i> 동화약품 </crp_nm_i> <stock_cd> 000020
		 * </stock_cd> <ceo_nm> 박기환 </ceo_nm> <crp_cls> Y </crp_cls> <crp_no>
		 * 1101110043870 </crp_no> <bsn_no> 1108100102 </bsn_no> <adr> 서울특별시 중구 후암로 98
		 * 19층(남대문로5가) </adr> <hm_url> www.dong-wha.co.kr </hm_url> <ir_url></ir_url>
		 * <phn_no> 02-2021-9300 </phn_no> <fax_no> 753-2347 </fax_no> <ind_cd> 21210
		 * </ind_cd> <est_dt> 18970925 </est_dt> <acc_mt> 12 </acc_mt> </result>
		 */
		
		sb += ddoc.select("crp_nm").text().trim() + ",";
		sb += ddoc.select("crp_nm_e").text().trim() + ",";
		sb += ddoc.select("crp_nm_i").text().trim() + ",";
		sb += ddoc.select("stock_cd").text().trim() + ",";
		sb += ddoc.select("ceo_nm").text().trim() + ",";
		sb += ddoc.select("crp_cls").text().trim() + ",";
		sb += ddoc.select("crp_no").text().trim() + ",";
		sb += ddoc.select("bsn_no").text().trim() + ",";
		sb += ddoc.select("adr").text().trim() + ",";
		sb += ddoc.select("hm_url").text().trim() + ",";
		sb += ddoc.select("ir_url").text().trim() + ",";
		sb += ddoc.select("phn_no").text().trim() + ",";
		sb += ddoc.select("fax_no").text().trim() + ",";
		sb += ddoc.select("ind_cd").text().trim() + ",";
		sb += ddoc.select("est_dt").text().trim() + ",";
		sb += ddoc.select("acc_mt").text().trim();

		/*System.out.println(sb);*/
		return sb;
	}
	
	public static String detail2csvrep(String cnt) throws IOException {
		Pattern pt 
		= Pattern.compile("[\\&#039;\\&#035;\\&quot;\\&gt;\\&lt;\\&amp;\\=\\<\\>\\，\\/\\,\\\\\"\\.\\?\\!\\#\\%\\^\\&\\*\\[\\]\\{\\}\\|\\t\\n\\;\\:\\+\\-\\`\\~\\(\\)]");
		Pattern urlonly 
		= Pattern.compile("[\\，\\,]");
		String sb = "";
		File fi = new File("C:\\Webwork\\compathapi\\dartdetail\\dart상세" + cnt + ".xml");
		Document ddoc = null;
		try {
			ddoc = Jsoup.parse(fi, "UTF-8");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * <?xml version="1.0" encoding="utf-8"?> <result> <err_code> 000 </err_code>
		 * <err_msg> 정상 </err_msg> <crp_nm> 동화약품(주) </crp_nm> <crp_nm_e> DONGWHA
		 * PHARM.CO.,LTD </crp_nm_e> <crp_nm_i> 동화약품 </crp_nm_i> <stock_cd> 000020
		 * </stock_cd> <ceo_nm> 박기환 </ceo_nm> <crp_cls> Y </crp_cls> <crp_no>
		 * 1101110043870 </crp_no> <bsn_no> 1108100102 </bsn_no> <adr> 서울특별시 중구 후암로 98
		 * 19층(남대문로5가) </adr> <hm_url> www.dong-wha.co.kr </hm_url> <ir_url></ir_url>
		 * <phn_no> 02-2021-9300 </phn_no> <fax_no> 753-2347 </fax_no> <ind_cd> 21210
		 * </ind_cd> <est_dt> 18970925 </est_dt> <acc_mt> 12 </acc_mt> </result>
		 */
		
				/*ddoc.tagName("crp_nm").text();*/
		
		sb+=pt.matcher(ddoc.select("crp_nm").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("crp_nm_e").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("crp_nm_i").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("stock_cd").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("ceo_nm").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("crp_cls").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("crp_no").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("bsn_no").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("adr").text().trim()).replaceAll("") + ",";
		sb+=urlonly.matcher(ddoc.select("hm_url").text().trim()).replaceAll("") + ",";
		sb+=urlonly.matcher(ddoc.select("ir_url").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("phn_no").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("fax_no").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("ind_cd").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("est_dt").text().trim()).replaceAll("") + ",";
		sb+=pt.matcher(ddoc.select("acc_mt").text().trim()).replaceAll("");
		/*System.out.println(sb);*/
		return sb;
	}
	

}
