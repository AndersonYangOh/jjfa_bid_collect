package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.List;

public class NMGHLBEListModel implements Serializable {
	private int RowCount;
	private List<NMGHLBEModel> Table;
	public int getRowCount() {
		return RowCount;
	}
	public void setRowCount(int rowCount) {
		RowCount = rowCount;
	}
	public List<NMGHLBEModel> getTable() {
		return Table;
	}
	public void setTable(List<NMGHLBEModel> table) {
		Table = table;
	}
	
	
	
}
