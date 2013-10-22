/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tmobile.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author aboulton
 */
public class CallUsage {
    private String ctn;

    @SerializedName("usage")
    private List<CallRecord> usage;
    
    public String getCtn() {
        return ctn;
    }

    public void setCtn(String ctn) {
        this.ctn = ctn;
    }

    public List<CallRecord> getUsage() {
        return usage;
    }

    public void setUsage(List<CallRecord> usage) {
        this.usage = usage;
    }
    
    
}

