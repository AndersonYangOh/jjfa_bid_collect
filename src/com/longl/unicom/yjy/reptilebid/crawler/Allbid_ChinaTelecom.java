package com.longl.unicom.yjy.reptilebid.crawler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.longl.unicom.yjy.reptilebid.model.YNbidListModel;
import com.longl.unicom.yjy.reptilebid.model.YNbidModel;
import com.longl.unicom.yjy.reptilebid.model.ZJbidListModel;
import com.longl.unicom.yjy.reptilebid.model.ZJbidModel;
import com.longl.unicom.yjy.reptilebid.service.IBidService;
import com.longl.unicom.yjy.reptilebid.util.HTTPSUtil;
import com.longl.unicom.yjy.reptilebid.util.HttpTool;

public class Allbid_ChinaTelecom {
	private IBidService bidservice;
	private String zhaob_pageurl = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/announcementjoin/list.do?provinceJT=JT";
	private String zhaob_pageurl2 = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/announcementjoin/list.do?provinceJT=NJT";
	private String zhongb_pageurl = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/resultannounc/listForAd.do?provinceJT=JT";
	private String zhongb_pageurl2 = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/resultannounc/listForAd.do?provinceJT=NJT";

	/**
	 * 电信采购网
	 * 
	 */
	public Allbid_ChinaTelecom(IBidService bidservice) {
		this.bidservice = bidservice;
		try {
			Bid_ZhaoB(zhaob_pageurl);
			Bid_ZhaoB(zhaob_pageurl2);
			
			Bid_ZhongB(zhongb_pageurl);
			Bid_ZhongB(zhongb_pageurl2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 招标
	public void Bid_ZhaoB(String url) throws Exception {
		URL u = new URL(url);
		if ("https".equalsIgnoreCase(u.getProtocol())) {
			HTTPSUtil.ignoreSsl();
		}
		System.out.println("url=" + u.toString());
		Connection con = Jsoup.connect(u.toString());
		Document doc = con.get();
		Element element = doc.select("table[class=table_data]").first();
		Elements elements = element.select("tr");
		String city = null;
		String province = null;
		String title = null;
		String dtime = null;
		String etime = null;
		String detailurl = null;
		String snum = null;
		int num = 1;
		for (Element e : elements) {
			if (num > 1) {

				snum = e.select("td").get(3).text();
				String date = e.select("td").get(5).text();
				dtime = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.parse(date));
				
				etime = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(e.select("td").get(7).text()));
				title = e.select("a").text();
				province = e.select("td").get(0).text();
				if (province.equalsIgnoreCase("集团")) {
					province = "北京";
				}
				String aa = e.select("a").attr("onclick").replace("view(", "")
						.replace(")", "").replaceAll("'", "");
				String aaa[] = aa.split(",");
				detailurl = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/purchaseannouncebasic/viewHome.do?encryCode="
						+ aaa[2] + "&id=" + aaa[0];
				System.out.println(province + "|" + etime + "|" + title + "|"
						+ dtime + "|" + detailurl);
				 bidservice.writeBidtoDB("tongx", title, detailurl, dtime, snum,
				 "中国电信", null, province, city, etime);

			}
			num++;
		}
	}

	// 中标
	public void Bid_ZhongB(String url) throws Exception {
		URL u = new URL(url);
		if ("https".equalsIgnoreCase(u.getProtocol())) {
			HTTPSUtil.ignoreSsl();
		}
		System.out.println("url=" + u.toString());
		Connection con = Jsoup.connect(u.toString());
		Document doc = con.get();
		Element element = doc.select("table[class=table_data]").first();
		Elements elements = element.select("tr");
		String city = null;
		String province = null;
		String title = null;
		String dtime = null;
		String detailurl = null;
		int num = 1;
		for (Element e : elements) {
			if (num > 1) {

				String date = e.select("td").get(2).text();
				dtime = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.parse(date));				
				title = e.select("a").text();
				province = e.select("td").get(0).text();
				if (province.equalsIgnoreCase("集团")) {
					province = "北京";
				}
				String aa = e.select("a").attr("onclick").replace("view(", "")
						.replace(")", "").replaceAll("'", "");
				String aaa[] = aa.split(",");
				detailurl = "https://caigou.chinatelecom.com.cn/MSS-PORTAL/resultannounc/viewHome.do?id="+aaa[0]+"&encryCode=" + aaa[1];
				System.out.println(province + "|"  + "|" + title + "|"
						+ dtime + "|" + detailurl);
				 bidservice.writeBidtoDB("tongx", title, detailurl, dtime, null,
				 "中国电信", null, province, city, null);

			}
			num++;
		}
	}

	public static void main(String[] args) {
		new Allbid_ChinaTelecom(null);

	}
}