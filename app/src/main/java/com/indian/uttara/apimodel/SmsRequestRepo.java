package com.indian.uttara.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SmsRequestRepo {

	@SerializedName("result")
	@Expose
	private String result;

	/**
	*
	* @return
	* The result
	*/
	public String getResult() {
	return result;
	}

	/**
	*
	* @param result
	* The result
	*/
	public void setResult(String result) {
	this.result = result;
	}


	public SmsRequestRepo withResult(String result) {
	this.result = result;
	return this;
	}

}