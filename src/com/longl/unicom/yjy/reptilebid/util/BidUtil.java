package com.longl.unicom.yjy.reptilebid.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BidUtil {
	/**
	 * 筛选以内容为基础，从开始字符到结束字符内容
	 * @param val 内容
	 * @param regex_start 开始字符
	 * @param regex_end 结束字符
	 * @return
	 */
	public static String getContent(String val, String regex_start,
			String regex_end) {
		int s = val.indexOf(regex_start) + regex_start.length();
		int e = val.indexOf(regex_end);
		return val.substring(s, e);
	}
	/**
	 * 筛选以内容为基础，从开始字符到最后的内容
	 * @param val 内容
	 * @param regex_start 开始字符
	 * @return
	 */
	public static String getStartContent(String val, String regex_start) {
		int s = val.indexOf(regex_start) + regex_start.length();
		return val.substring(s);
	}
	
	// 将 GB2312 编码格式的字符串转换为 UTF-8 格式的字符串：

	public static String gb2312ToUtf8(String str) {

	        String urlEncode = "" ;

	        try {

	            urlEncode = URLEncoder.encode (str, "UTF-8" );

	        } catch (UnsupportedEncodingException e) {

	            e.printStackTrace();

	        }

	        return urlEncode;

	}
}
