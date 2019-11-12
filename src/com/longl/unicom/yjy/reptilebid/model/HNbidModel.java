package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HNbidModel implements Serializable {
	private int total;
	private String hzMap;
	private List<HNListbidModel> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getHzMap() {
		return hzMap;
	}
	public void setHzMap(String hzMap) {
		this.hzMap = hzMap;
	}
	public List<HNListbidModel> getRows() {
		return rows;
	}
	public void setRows(List<HNListbidModel> rows) {
		this.rows = rows;
	}
	
	}
