package com.indian.uttara.apimodel;

import java.sql.Date; 
import java.util.Map;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyCartDetailsRepo {

	@SerializedName("mPhoneNo")
	@Expose
	private String mPhoneNo;
	
	// ID is the key & Quantity is the value
	@SerializedName("mProductDetails")
	@Expose
	private Map<Long,Integer> mProductDetails;
	@SerializedName("mDate")
	@Expose
	private Date mDate;
	
	public String getmPhoneNo() {
		return mPhoneNo;
	}
	public void setmPhoneNo(String mPhoneNo) {
		this.mPhoneNo = mPhoneNo;
	}
	
	public Map<Long, Integer> getmProductDetails() {
		return mProductDetails;
	}
	public void setmProductDetails(Map<Long, Integer> mProductDetails) {
		this.mProductDetails = mProductDetails;
	}
	public Date getmDate() {
		return mDate;
	}
	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}
	

}
