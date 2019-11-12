package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.List;

public class HUNLDListModel implements Serializable {
	private String code;
	private int count;
	private List<HUNLDModel> data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<HUNLDModel> getData() {
		return data;
	}
	public void setData(List<HUNLDModel> data) {
		this.data = data;
	}
	
}
