package com.indian.uttara.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayuHashRepo {

	@SerializedName("hash")
	@Expose
	private String hash;

	/**
	*
	* @return
	* The hash
	*/
	public String getHash() {
	return hash;
	}

	/**
	*
	* @param hash
	* The hash
	*/
	public void setHash(String hash) {
	this.hash = hash;
	}


	public PayuHashRepo withHash(String hash) {
	this.hash = hash;
	return this;
	}

}