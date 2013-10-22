/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tmobile.data;

import java.util.List;

/**
 *
 * @author aboulton
 */
public class BillingAccount {

    private String lastBillingDate;
    private String paymentType;
    private String nextBillingDate;

    private Balance balance;
    private List<Subscription> subscription;

    public String getLastBillingDate() {
        return lastBillingDate;
    }

    public void setLastBillingDate(String lastBillingDate) {
        this.lastBillingDate = lastBillingDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(String nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Subscription> getSubscriptions() {
        return subscription;
    }

    public void setSubscriptions(List<Subscription> subscription) {
        this.subscription = subscription;
    }

    @Override
    public String toString() {
        return "BillingAccount{" + "lastBillingDate=" + lastBillingDate + ", paymentType=" + paymentType + ", nextBillingDate=" + nextBillingDate + ", balance=" + balance + ", subscription=" + subscription + '}';
    }



}