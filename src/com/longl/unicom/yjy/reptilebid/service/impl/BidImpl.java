package com.longl.unicom.yjy.reptilebid.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.longl.unicom.yjy.reptilebid.dao.IBidDao;
import com.longl.unicom.yjy.reptilebid.model.BidModel;
import com.longl.unicom.yjy.reptilebid.service.IBidService;

@Service
public class BidImpl implements IBidService {
	@Resource
	private IBidDao bidDao;

	@Override
	public void writeBidtoDB(String tablename, String title, String url,
			String date, String num, String filenum, String content,
			String province, String city, String endtime) {
		// 去重
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tablename", tablename);
		map.put("title", title);
		map.put("dtime", date);
		map.put("url", url.replace("#",""));
		int count = bidDao.searchlistBysame(map);
		if (count < 1) {
			BidModel bid = new BidModel();
			bid.setCity(city);
			bid.setContent(content);
			bid.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date()));
			bid.setDtime(date);
			bid.setFilenum(filenum);
			bid.setNum(num);
			bid.setProvince(province);
			bid.setTablename(tablename);
			bid.setTitle(title);
			bid.setUrl(url);
			bid.setEndtime(endtime);
			bid.setBidtype(1);
			int updates = bidDao.insert(bid);
			System.out.println("------------->");
			// 执行插入操作
			if (updates == 1) {
				System.out.println("mysql插入成功");
			}
		} else {
			System.out.println("title=" + title + "重复");
		}

	}
	
	@Override
	public void zbBidtoDB(String tablename, String title, String url,
			String date, String num, String filenum, String content,
			String province, String city, String endtime) {
		
		// 去重
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tablename", tablename);
		map.put("title", title);
		map.put("dtime", date);
		map.put("url", url.replace("#",""));
		int count = bidDao.searchlistBysame(map);
		if (count < 1) {
			BidModel bid = new BidModel();
			bid.setCity(city);
			bid.setContent(content);
			bid.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Date()));
			bid.setDtime(date);
			bid.setFilenum(filenum);
			bid.setNum(num);
			bid.setProvince(province);
			bid.setTablename(tablename);
			bid.setTitle(title);
			bid.setUrl(url);
			bid.setEndtime(endtime);
			bid.setBidtype(2);
			int updates = bidDao.insert(bid);
			System.out.println("------------->");
			// 执行插入操作
			if (updates == 1) {
				System.out.println("mysql插入成功");
			}
		} else {
			System.out.println("title=" + title + "重复");
		}

	}
	
	public List searchlist(Map map){
		return bidDao.searchlist(map);
	}

	@Override
	public List getzbinfolist() {
		// TODO Auto-generated method stub
		return bidDao.getzbinfolist();
	}
	
	@Override
	public List zbdetailsearch(Map map) {
		// TODO Auto-generated method stub
		return bidDao.zbdetailsearch(map);
	}

	@Override
	public int insertzbdetial(Map map) {
		// TODO Auto-generated method stub
		return bidDao.insertzbdetial(map);
	}

	@Override
	public List gettongjiinfolist(Map map) {
		// TODO Auto-generated method stub
		return bidDao.gettongjiinfolist(map);
	}

	@Override
	public int inserttongjidetial(Map map) {
		// TODO Auto-generated method stub
		return bidDao.inserttongjidetial(map);
	}

	@Override
	public void updateYGHQ() {
		// TODO Auto-generated method stub
		 bidDao.updateyghq();
	}
}
