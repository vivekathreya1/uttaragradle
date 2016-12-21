package com.indian.uttara.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartQntValidateRepo {
	@SerializedName("service_name_id")
	@Expose
	private Integer serviceNameId;
	@SerializedName("service_name")
	@Expose
	private String serviceName;
	@SerializedName("quantity")
	@Expose
	private Integer quantity;

	/**
	*
	* @return
	* The serviceNameId
	*/
	public Integer getServiceNameId() {
	return serviceNameId;
	}

	/**
	*
	* @param serviceNameId
	* The service_name_id
	*/
	public void setServiceNameId(Integer serviceNameId) {
	this.serviceNameId = serviceNameId;
	}

	/**
	*
	* @return
	* The serviceName
	*/
	public String getServiceName() {
	return serviceName;
	}

	/**
	*
	* @param serviceName
	* The service_name
	*/
	public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
	}

	/**
	*
	* @return
	* The quantity
	*/
	public Integer getQuantity() {
	return quantity;
	}

	/**
	*
	* @param quantity
	* The quantity
	*/
	public void setQuantity(Integer quantity) {
	this.quantity = quantity;
	}
	
	
}
