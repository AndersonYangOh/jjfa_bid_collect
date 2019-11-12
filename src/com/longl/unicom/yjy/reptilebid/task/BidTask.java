package com.longl.unicom.yjy.reptilebid.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时任务
 * 
 * @author longl
 * 
 */
@Component
public class BidTask {

	@Resource
	private IBidService bidservice;

	/////////////////////////////////////// 企业招标信息///////////////////////////////////////////////////
	/**
	 * 中国移动招中标执行时间
	 */
	// @Scheduled(cron = "0 23 19 * * ? ")
	@Scheduled(cron = "30 27 7-20/4 * * ? ")
	public void zb_yidongbid() throws Exception {
		System.out.println("------移动执行---------");
		new Allbid_ChinaMobile(bidservice);
	}

	/**
	 * 中国电信招中标执行时间
	 */
	// @Scheduled(cron = "0 24 19 * * ? ")
	@Scheduled(cron = "30 28 7-20/4 * * ? ")
	public void zb_dianxinbid() throws Exception {
		System.out.println("------电信执行---------");
		new Allbid_ChinaTelecom(bidservice);
	}

	/////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 测试招标执行时间 每隔5秒执行一次
	 */
	@Scheduled(cron = "0 0/5 * * * ? ")
	public void testbid() {
		System.out.println("--------招标心跳-----------");

	}
	





}
