package com.longl.unicom.yjy.reptilebid.model;

import java.io.Serializable;
import java.util.Date;

public class SCbidModel implements Serializable{
	private String Id; 
	private String ProjectCode; 
	private String Title; 
	private String CreateDate; 
	private String CreateDateTime; 
	private String CreateDateStr; 
	private String CreateDateAll; 
	private String CityKey; 
	private String NoticeType; 
	private String TableName; 
	private String Link; 
	private String TradeName; 
	private String username; 
	private String province; 
	private String businessType; 
	private int Concern;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getProjectCode() {
		return ProjectCode;
	}
	public void setProjectCode(String projectCode) {
		ProjectCode = projectCode;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getCreateDateTime() {
		return CreateDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		CreateDateTime = createDateTime;
	}
	public String getCreateDateStr() {
		return CreateDateStr;
	}
	public void setCreateDateStr(String createDateStr) {
		CreateDateStr = createDateStr;
	}
	public String getCreateDateAll() {
		return CreateDateAll;
	}
	public void setCreateDateAll(String createDateAll) {
		CreateDateAll = createDateAll;
	}
	public String getCityKey() {
		return CityKey;
	}
	public void setCityKey(String cityKey) {
		CityKey = cityKey;
	}
	public String getNoticeType() {
		return NoticeType;
	}
	public void setNoticeType(String noticeType) {
		NoticeType = noticeType;
	}
	public String getTableName() {
		return TableName;
	}
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getTradeName() {
		return TradeName;
	}
	public void setTradeName(String tradeName) {
		TradeName = tradeName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String Username) {
		username = Username;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String Province) {
		province = Province;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String BusinessType) {
		businessType = BusinessType;
	}
	public int getConcern() {
		return Concern;
	}
	public void setConcern(int concern) {
		Concern = concern;
	} 
	
}
