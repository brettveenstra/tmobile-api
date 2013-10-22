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
public class CallRecord
{
    private String timestamp;
    private Number amount;
    private String numberCalled;
    private String unitType;
    private String description;
 
    private Balance cost;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
    }

    public String getNumberCalled() {
        return numberCalled;
    }

    public void setNumberCalled(String numberCalled) {
        this.numberCalled = numberCalled;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Balance getCost() {
        return cost;
    }

    public void setCost(Balance cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CallRecord{" + "timestamp=" + timestamp + ", amount=" + amount + ", numberCalled=" + numberCalled + ", unitType=" + unitType + ", description=" + description + ", cost=" + cost + '}';
    }
    
    
}