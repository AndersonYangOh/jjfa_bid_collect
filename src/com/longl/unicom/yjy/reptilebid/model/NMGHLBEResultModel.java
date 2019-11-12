package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.List;

public class NMGHLBEResultModel implements Serializable {
	private String[] controls;
	private NMGHLBEListModel custom;
	private NMGHLBEStModel status;
	public String[] getControls() {
		return controls;
	}
	public void setControls(String[] controls) {
		this.controls = controls;
	}
	public NMGHLBEListModel getCustom() {
		return custom;
	}
	public void setCustom(NMGHLBEListModel custom) {
		this.custom = custom;
	}
	public NMGHLBEStModel getStatus() {
		return status;
	}
	public void setStatus(NMGHLBEStModel status) {
		this.status = status;
	}
	 
	
	
}
