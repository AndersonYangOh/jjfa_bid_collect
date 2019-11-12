package com.longl.unicom.yjy.reptilebid.model;

import java.util.List;

public class GGModel {
	private int ttlpage;
	private int ttlrow;
	private int usetime;
	private int currentpage;
	private boolean success;
	private List<GGDetailModel> data;
	public int getTtlpage() {
		return ttlpage;
	}
	public void setTtlpage(int ttlpage) {
		this.ttlpage = ttlpage;
	}
	public int getTtlrow() {
		return ttlrow;
	}
	public void setTtlrow(int ttlrow) {
		this.ttlrow = ttlrow;
	}
	public int getUsetime() {
		return usetime;
	}
	public void setUsetime(int usetime) {
		this.usetime = usetime;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<GGDetailModel> getData() {
		return data;
	}
	public void setData(List<GGDetailModel> data) {
		this.data = data;
	}
}
