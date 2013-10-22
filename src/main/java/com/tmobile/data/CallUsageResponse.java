/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmobile.data;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author aboulton
 */
public class CallUsageResponse {
    private String errorText;
    private int errorCode;

    @SerializedName("response")
    private CallUsageRoot callUsageRoot;

    public CallUsage getCallUsage() {
        return callUsageRoot.getData();
    }  
}




