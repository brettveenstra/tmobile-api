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
public class Balance {

    private Number rawValue;
    private Number roundedValue;

    public Number getRawValue() {
        return rawValue;
    }

    public void setRawValue(Number rawValue) {
        this.rawValue = rawValue;
    }

    public Number getRoundedValue() {
        return roundedValue;
    }

    public void setRoundedValue(Number roundedValue) {
        this.roundedValue = roundedValue;
    }

    @Override
    public String toString() {
        return "Balance{" + "rawValue=" + rawValue + ", roundedValue=" + roundedValue + '}';
    }

}
