package com.longl.unicom.yjy.reptilebid.service;

import java.util.List;
import java.util.Map;

public interface IBidService {
	/**
	 * 招标数据
	 * 
	 * @param tablename
	 *            数据库表名
	 * @param title
	 *            主题
	 * @param url
	 *            链接的url
	 * @param date
	 *            日期 格式：yyyyMMDDHHmmss
	 * @param num
	 *            采购编号
	 * @param filenum
	 *            文件号
	 * @param content
	 *            内容
	 * @param province
	 *            省份
	 * @param city
	 *            城市
	 * @param endtime
	 *            截至时间
	 * @throws Exception
	 */
	public void writeBidtoDB(String tablename, String title, String url,
			String date, String num, String filenum, String content,
			String province, String city, String endtime);

	/**
	 * 中标数据
	 * 
	 * @param tablename
	 *            数据库表名
	 * @param title
	 *            主题
	 * @param url
	 *            链接的url
	 * @param date
	 *            日期 格式：yyyyMMDDHHmmss
	 * @param num
	 *            采购编号
	 * @param filenum
	 *            文件号
	 * @param content
	 *            内容
	 * @param province
	 *            省份
	 * @param city
	 *            城市
	 * @param endtime
	 *            截至时间
	 * @throws Exception
	 */
	public void zbBidtoDB(String tablename, String title, String url,
			String date, String num, String filenum, String content,
			String province, String city, String endtime);

	List searchlist(Map map);
	
	List getzbinfolist();
	List zbdetailsearch(Map map);
	
	int insertzbdetial(Map map);
	
	List gettongjiinfolist(Map map);
	
	int inserttongjidetial(Map map);
	
	void updateYGHQ();
}
