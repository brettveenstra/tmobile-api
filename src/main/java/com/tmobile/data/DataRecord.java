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
public class DataRecord
{
    private String timestamp;
    private String volume;

    private Balance cost;

    public String getTimestamp() {
        return timestamp;
    }

    public String getVolume() {
        return volume;
    }

    public Balance getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "DataRecord{" + "timestamp=" + timestamp + ", volume=" + volume + ", cost=" + cost + '}';
    }
    
    
}