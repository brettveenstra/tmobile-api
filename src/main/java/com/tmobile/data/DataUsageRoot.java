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
public class DataUsageRoot {

    @SerializedName("data")
    private DataUsage usage;

    public DataUsage getUsage() {
        return usage;
    }
}
