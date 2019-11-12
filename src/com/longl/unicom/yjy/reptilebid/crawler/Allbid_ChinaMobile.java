package com.longl.unicom.yjy.reptilebid.crawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

public class Allbid_ChinaMobile {
	private IBidService bidservice;

	public Allbid_ChinaMobile(IBidService bidservice) {
		this.bidservice=bidservice;
		String url1 = "https://b2b.10086.cn/b2b/main/listVendorNoticeResult.html?noticeBean.noticeType=2";
		String param1 = "page.currentPage=1&page.perPageSize=20&noticeBean.sourceCH=&noticeBean.source=&noticeBean.title=&noticeBean.startDate=&noticeBean.endDate=";
		String url2 = "https://b2b.10086.cn/b2b/main/listVendorNoticeResult.html?noticeBean.noticeType=16";
		String param2 = "page.currentPage=1&page.perPageSize=20&noticeBean.sourceCH=&noticeBean.source=&noticeBean.title=&noticeBean.startDate=&noticeBean.endDate=";

		try {
			Bid_ZhaoB(url1, param1);
			Bid_ZhongB(url2, param2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 招标
	public void Bid_ZhaoB(String url, String param) throws Exception {
		URL u = new URL(url);
		if ("https".equalsIgnoreCase(u.getProtocol())) {
			HTTPSUtil.ignoreSsl();
		}
		System.out.println("url=" + u.toString());
		Connection con = Jsoup.connect(u.toString());
		con.data(param);
		Document doc = con.post();
		Elements elements = doc.select("table").first().select("tr");
		String city = null;
		String province = null;
		String title = null;
		String dtime = null;
		String detailurl = null;
		int num = 1;
		for (Element e : elements) {
			if (num>2) {
				detailurl = "https://b2b.10086.cn/b2b/main/viewNoticeContent.html?noticeBean.id="
						+ e.attr("onclick").replace("selectResult('", "")
								.replace("')", "");
				city = e.select("td").get(0).text();
				String date = e.select("td").get(3).text();
				dtime = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
				Element a = e.select("a").first();
				String t = a.attr("title");
				if (t == null || t.equalsIgnoreCase("")) {
					title = a.text();
				} else {
					title = t;
				}
				province=provincebycity(city);
				System.out.println(province+"|"+city+"|"+title+"|"+dtime+"|"+detailurl);
				bidservice.writeBidtoDB("tongx", title, detailurl, dtime, null,
						 "中国移动", null, province, city, null);

			}
			num ++;
		}
	}

	// 中标
	public void Bid_ZhongB(String url, String param) throws Exception {
		URL u = new URL(url);
		if ("https".equalsIgnoreCase(u.getProtocol())) {
			HTTPSUtil.ignoreSsl();
		}
		System.out.println("url=" + u.toString());
		Connection con = Jsoup.connect(u.toString());
		con.data(param);
		Document doc = con.post();
		Elements elements = doc.select("table").first().select("tr");
		String city = null;
		String province = null;
		String title = null;
		String dtime = null;
		String detailurl = null;
		int num = 1;
		for (Element e : elements) {
			if (num>2) {
				detailurl = "https://b2b.10086.cn/b2b/main/viewNoticeContent.html?noticeBean.id="
						+ e.attr("onclick").replace("selectResult('", "")
								.replace("')", "");
				city = e.select("td").get(0).text();
				String date = e.select("td").get(3).text();
				dtime = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new SimpleDateFormat("yyyy-MM-dd").parse(date));
				Element a = e.select("a").first();
				String t = a.attr("title");
				if (t == null || t.equalsIgnoreCase("")) {
					title = a.text();
				} else {
					title = t;
				}
				province=provincebycity(city);
				System.out.println(province+"|"+city+"|"+title+"|"+dtime+"|"+detailurl);
				bidservice.zbBidtoDB("tongx", title, detailurl, dtime, null,
						 "中国移动", null, province, city, null);


			}
			num ++;
		}
	}

	public static void main(String[] args) {
		new Allbid_ChinaMobile(null);

	}
	
	public String provincebycity(String province) {
		String provincecode = "北京";
		if (province.indexOf("天津")>=0) {
			provincecode = "天津";
		} else if (province.indexOf("河北")>=0) {
			provincecode = "河北";
		} else if (province.indexOf("山西")>=0) {
			provincecode = "山西";
		} else if (province.indexOf("内蒙古")>=0) {
			provincecode = "内蒙古";
		} else if (province.indexOf("辽宁")>=0) {
			provincecode = "辽宁";
		} else if (province.indexOf("吉林")>=0) {
			provincecode = "吉林";
		} else if (province.indexOf("黑龙江")>=0) {
			provincecode = "黑龙江";
		} else if (province.indexOf("上海")>=0) {
			provincecode = "上海";
		} else if (province.indexOf("江苏")>=0) {
			provincecode = "江苏";
		} else if (province.indexOf("浙江")>=0) {
			provincecode = "浙江";
		} else if (province.indexOf("安徽")>=0) {
			provincecode = "安徽";
		} else if (province.indexOf("福建")>=0) {
			provincecode = "福建";
		} else if (province.indexOf("江西")>=0) {
			provincecode = "江西";
		} else if (province.indexOf("山东")>=0) {
			provincecode = "山东";
		} else if (province.indexOf("河南")>=0) {
			provincecode = "河南";
		} else if (province.indexOf("湖北")>=0) {
			provincecode = "湖北";
		} else if (province.indexOf("湖南")>=0) {
			provincecode = "湖南";
		} else if (province.indexOf("广东")>=0) {
			provincecode = "广东";
		} else if (province.indexOf("广西")>=0) {
			provincecode = "广西";
		} else if (province.indexOf("海南")>=0) {
			provincecode = "海南";
		} else if (province.indexOf("重庆")>=0) {
			provincecode = "重庆";
		} else if (province.indexOf("四川")>=0) {
			provincecode = "四川";
		} else if (province.indexOf("贵州")>=0) {
			provincecode = "贵州";
		} else if (province.indexOf("云南")>=0) {
			provincecode = "云南";
		} else if (province.indexOf("西藏")>=0) {
			provincecode = "西藏";
		} else if (province.indexOf("陕西")>=0) {
			provincecode = "陕西";
		} else if (province.indexOf("甘肃")>=0) {
			provincecode = "甘肃";
		} else if (province.indexOf("青海")>=0) {
			provincecode = "青海";
		} else if (province.indexOf("宁夏")>=0) {
			provincecode = "宁夏";
		} else if (province.indexOf("新疆")>=0) {
			provincecode = "新疆";
		}

		return provincecode;
	}

}
