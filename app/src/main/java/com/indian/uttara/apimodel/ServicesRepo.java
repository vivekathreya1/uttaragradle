package com.indian.uttara.apimodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class ServicesRepo {
    @SerializedName("service_name_id")
    @Expose
    private Integer serviceNameId;
    @SerializedName("service_name")
    @Expose
    private String serviceName;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("service_s_decp")
    @Expose
    private String serviceSDecp;
    @SerializedName("service_l_decp")
    @Expose
    private String serviceLDecp;
    @SerializedName("service_price")
    @Expose
    private String servicePrice;
    @SerializedName("service_spec")
    @Expose
    private String serviceSpec;
    @SerializedName("service_avl_qnt")
    @Expose
    private Integer serviceAvlQnt;

    /**
     * @return The serviceNameId
     */
    public Integer getServiceNameId() {
        return serviceNameId;
    }

    /**
     * @param serviceNameId The service_name_id
     */
    public void setServiceNameId(Integer serviceNameId) {
        this.serviceNameId = serviceNameId;
    }

    /**
     * @return The serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName The service_name
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return The serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType The service_type
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @return The serviceSDecp
     */
    public String getServiceSDecp() {
        return serviceSDecp;
    }

    /**
     * @param serviceSDecp The service_s_decp
     */
    public void setServiceSDecp(String serviceSDecp) {
        this.serviceSDecp = serviceSDecp;
    }

    /**
     * @return The serviceLDecp
     */
    public String getServiceLDecp() {
        return serviceLDecp;
    }

    /**
     * @param serviceLDecp The service_l_decp
     */
    public void setServiceLDecp(String serviceLDecp) {
        this.serviceLDecp = serviceLDecp;
    }

    /**
     * @return The servicePrice
     */
    public String getServicePrice() {
        return servicePrice;
    }

    /**
     * @param servicePrice The service_price
     */
    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    /**
     * @return The serviceSpec
     */
    public String getServiceSpec() {
        return serviceSpec;
    }

    /**
     * @param serviceSpec The service_spec
     */
    public void setServiceSpec(String serviceSpec) {
        this.serviceSpec = serviceSpec;
    }

    /**
     * @return The serviceAvlQnt
     */
    public Integer getServiceAvlQnt() {
        return serviceAvlQnt;
    }

    /**
     * @param serviceAvlQnt The service_avl_qnt
     */
    public void setServiceAvlQnt(Integer serviceAvlQnt) {
        this.serviceAvlQnt = serviceAvlQnt;
    }

}
