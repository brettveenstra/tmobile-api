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
public class Profile {

    private String id;
    private String roleName;

    private BillingAccount billingAccount;
    private Balance balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", roleName=" + roleName + ", billingAccount=" + billingAccount + ", balance=" + balance + '}';
    }

}