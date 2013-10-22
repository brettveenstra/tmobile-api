/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tmobile.data;

/**
 *
 * @author aboulton
 */
public class Subscription {

    private String phoneNumber;
    private String contractEndDate;
    private String  callUsageLink;
    private String thirdPartyUsageLink;
    private String paymentType;
    private String trafficSOC;
    private String infoLink;
    private String tariffName;
    private String dataUsageLink;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getCallUsageLink() {
        return callUsageLink;
    }

    public void setCallUsageLink(String callUsageLink) {
        this.callUsageLink = callUsageLink;
    }

    public String getThirdPartyUsageLink() {
        return thirdPartyUsageLink;
    }

    public void setThirdPartyUsageLink(String thirdPartyUsageLink) {
        this.thirdPartyUsageLink = thirdPartyUsageLink;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTrafficSOC() {
        return trafficSOC;
    }

    public void setTrafficSOC(String trafficSOC) {
        this.trafficSOC = trafficSOC;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public String getDataUsageLink() {
        return dataUsageLink;
    }

    public void setDataUsageLink(String dataUsageLink) {
        this.dataUsageLink = dataUsageLink;
    }

    @Override
    public String toString() {
        return "Subscription{" + "phoneNumber=" + phoneNumber + ", contractEndDate=" + contractEndDate + ", callUsageLink=" + callUsageLink + ", thirdPartyUsageLink=" + thirdPartyUsageLink + ", paymentType=" + paymentType + ", trafficSOC=" + trafficSOC + ", infoLink=" + infoLink + ", tariffName=" + tariffName + ", dataUsageLink=" + dataUsageLink + '}';
    }

}