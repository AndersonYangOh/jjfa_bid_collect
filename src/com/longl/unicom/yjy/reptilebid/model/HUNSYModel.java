package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;

public class HUNSYModel implements Serializable {
	private String id;
	private String Title;
	private String time;
	private String status;
	private String category;
	private String type;
	private boolean IsWhole;
	private String method;
	private String url;
	private boolean issection;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isIsWhole() {
		return IsWhole;
	}
	public void setIsWhole(boolean isWhole) {
		IsWhole = isWhole;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isIssection() {
		return issection;
	}
	public void setIssection(boolean issection) {
		this.issection = issection;
	}
	
}
