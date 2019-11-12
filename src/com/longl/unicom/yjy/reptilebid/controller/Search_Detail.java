package com.longl.unicom.yjy.reptilebid.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.longl.unicom.yjy.reptilebid.model.BidModel;
import com.longl.unicom.yjy.reptilebid.model.YNZbDetailModel;
import com.longl.unicom.yjy.reptilebid.service.IBidService;
import com.longl.unicom.yjy.reptilebid.util.BidUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * 搜索信息
 * 
 * @author longl
 * 
 */
public class Search_Detail {
	private IBidService bidservice;

	private static int sssum = 0;

	public Search_Detail(IBidService bidservice) {
		this.bidservice = bidservice;
		System.out.println("I'm coming!");
		Map map=new HashMap();
		map.put("starttime", "20181201000000");
		map.put("endtime", "20190101000000");
		List<BidModel> list = bidservice.zbdetailsearch(map);
		for (BidModel m : list) {
			visit(m);
		}
	}

	public void visit(BidModel m) {
		sssum++;
//		if (sssum > 7300) {
			System.out.println(sssum + "|url:" + m.getUrl());
			Win_detail(m);
//		}
	}

	/**
	 * 利用正则表达式判断字符串是否是数字
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public void Win_detail(BidModel m) {
		Document doc;
		String content = null;

		if (m.getUrl().startsWith("http")) {
			String str[] = m.getUrl().split(":");
			if (str.length > 2) {
				String port = str[2].split("/")[0];
				if (isNumeric(port)) {
					try {
						doc = Jsoup.connect(m.getUrl()).timeout(5000).get();
						content = doc.html();
					} catch (Exception e) {
						Map map = new HashMap();
						map.put("bidid", 0);
						map.put("url", "超时问题");
						map.put("name", "异常");
						bidservice.inserttongjidetial(map);
						return;
					}
				} else {
					Map map = new HashMap();
					map.put("bidid", 0);
					map.put("url", "端口问题");
					map.put("name", "异常");
					bidservice.inserttongjidetial(map);
					return;
				}
			} else {
				try {
					doc = Jsoup.connect(m.getUrl()).timeout(5000).get();
					content = doc.html();
				} catch (Exception e) {
					Map map = new HashMap();
					map.put("bidid", 0);
					map.put("url", "超时问题");
					map.put("name", "异常");
					bidservice.inserttongjidetial(map);
					return;
				}
			}
		} else {
			Map map = new HashMap();
			map.put("bidid", 0);
			map.put("url", "url问题");
			map.put("name", "异常");
			bidservice.inserttongjidetial(map);
			return;
		}
	

		if (content.indexOf("移动通信") >= 0 || content.indexOf("中移通信") >= 0 || content.indexOf("中移信息") >= 0
				|| content.indexOf("移动信息") >= 0 || content.indexOf("中移电子") >= 0 || content.indexOf("中移物联网") >= 0
				|| content.indexOf("中移互联网") >= 0) {
			Map map = new HashMap();
			map.put("bidid", m.getId());
			map.put("url", m.getUrl());
			map.put("name", "中国移动");
			map.put("title", m.getTitle());
			bidservice.inserttongjidetial(map);
		}
		if (content.indexOf("联合网络") >= 0 || content.indexOf("联通") >= 0) {
			Map map = new HashMap();
			map.put("bidid", m.getId());
			map.put("url", m.getUrl());
			map.put("name", "中国联通");
			map.put("title", m.getTitle());
			bidservice.inserttongjidetial(map);
		}
		if (content.indexOf("电信集团") >= 0 || content.indexOf("天翼") >= 0 || content.indexOf("电信股份") >= 0) {
			Map map = new HashMap();
			map.put("bidid", m.getId());
			map.put("url", m.getUrl());
			map.put("name", "中国电信");
			map.put("title", m.getTitle());
			bidservice.inserttongjidetial(map);
		}

	}

	public static void main(String[] args) throws Exception {
		// new Search_Detail(null);
		for (int i = 0; i < 5; i++) {
			try {
				Jsoup.connect("http:///www.zsptztb.com.cn/zsptztb/InfoDetail/?InfoID=zcy-3570553&CategoryNum=011004001")
						.timeout(5000).get();
			} catch (Exception e) {
				System.out.println("OK1");
			}

		}
	}

}