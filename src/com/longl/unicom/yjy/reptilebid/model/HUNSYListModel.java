package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.List;

public class HUNSYListModel implements Serializable {
	private String result;
	private String msg;
	private List<HUNSYModel> json;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<HUNSYModel> getJson() {
		return json;
	}
	public void setJson(List<HUNSYModel> json) {
		this.json = json;
	}

	
}
