package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.List;

public class HBEZGGListModel implements Serializable{
	private int total;
	private int totalPage;
	private List<HBEZGGModel> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<HBEZGGModel> getRows() {
		return rows;
	}
	public void setRows(List<HBEZGGModel> rows) {
		this.rows = rows;
	}
	
}
