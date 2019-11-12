package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;

public class HUNLDModel implements Serializable {
	private String NoticeTitle;
	private String PublishTime;
	public String getNoticeTitle() {
		return NoticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		NoticeTitle = noticeTitle;
	}
	public String getPublishTime() {
		return PublishTime;
	}
	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}
	
}
