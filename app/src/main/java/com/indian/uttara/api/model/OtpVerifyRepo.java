package com.indian.uttara.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OtpVerifyRepo {

	@SerializedName("error")
	@Expose
	private Boolean error;
	@SerializedName("message")
	@Expose
	private String message;

	/**
	 * 
	 * @return The error
	 */
	public Boolean getError() {
		return error;
	}

	/**
	 * 
	 * @param error
	 *            The error
	 */
	public void setError(Boolean error) {
		this.error = error;
	}

	/**
	 * 
	 * @return The message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 
	 * @param message
	 *            The message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}