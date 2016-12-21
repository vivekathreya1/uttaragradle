package com.indian.uttara.electrical.model;

/**
 * Created by Vivekathreya on 10/8/2016.
 */
public class Services {

    String serviceName;
    String serviceBriefDesc;
    String serviceFullDesc;
    String servicePrice;
    boolean selected = false;

    public Services(String serviceName, String serviceBriefDesc, String servicePrice, String serviceFullDesc) {
        super();
        this.serviceName = serviceName;
        this.serviceBriefDesc = serviceBriefDesc;
        this.servicePrice = servicePrice;
        this.serviceFullDesc = serviceFullDesc;
    }

    public String getServiceBriefDesc() {
        return serviceBriefDesc;
    }

    public void setServiceBriefDesc(String serviceBriefDesc) {
        this.serviceBriefDesc = serviceBriefDesc;
    }

    public String getServiceFullDesc() {
        return serviceFullDesc;
    }

    public void setServiceFullDesc(String serviceFullDesc) {
        this.serviceFullDesc = serviceFullDesc;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
