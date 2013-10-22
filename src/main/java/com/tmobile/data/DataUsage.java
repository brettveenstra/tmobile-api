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
public class DataUsage {

    private String ctn;
    
    @SerializedName("usage")
    private List<DataRecord> dataRecords;

    @Override
    public String toString() {
        return "DataUsage{" + "ctn=" + ctn + ", dataRecords=" + dataRecords + '}';
    }        

    public List<DataRecord> getDataRecords() {
        return dataRecords;
    }
    
    
}
