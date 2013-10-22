/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmobile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tmobile.data.Balance;
import com.tmobile.data.BillingAccount;
import com.tmobile.data.CallUsageResponse;
import com.tmobile.data.DataUsageResponse;
import com.tmobile.data.Profile;
import com.tmobile.data.Subscription;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Adam Boulton
 */
public class TMobileParsing {

    protected static BillingAccount extractBillingAccount(JsonObject jsonProfile) {
        BillingAccount billingAccount = new BillingAccount();
        JsonObject jsonBillingAccount = jsonProfile.getAsJsonObject("billingAccount");
        String lastBillingDate = jsonBillingAccount.get("lastBillingDate").getAsString();
        String paymentType = jsonBillingAccount.get("paymentType").getAsString();
        String nextBillingDate = jsonBillingAccount.get("nextBillingDate").getAsString();

        billingAccount.setLastBillingDate(lastBillingDate);
        billingAccount.setPaymentType(paymentType);
        billingAccount.setNextBillingDate(nextBillingDate);

        return billingAccount;
    }

    protected static Balance extractBalance(JsonObject jsonBillingAccount) {
        Balance balance = new Balance();
        JsonObject jsonBalance = jsonBillingAccount.getAsJsonObject("balance");
        balance.setRawValue(Float.valueOf(jsonBalance.get("rawValue").toString()));
        balance.setRoundedValue(Integer.valueOf(jsonBalance.get("roundedValue").toString()));

        return balance;
    }

    protected static String getDataFromUrl(String url, String basicAuthToken) throws IOException {
        URL urlObj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) urlObj.openConnection();
        con.setRequestProperty("Authorization", "Basic " + basicAuthToken);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String userInfo = in.readLine(); //Successfull invocation of the web service will see JSON in the HTTP response body
        in.close();

        return userInfo;
    }

    protected static String getToken(String username, String password) throws IOException {
        byte[] auth = String.valueOf(username + ":" + password).getBytes();
        String basicAuthToken = Base64.encodeBase64String(auth);

        String authenticationData = getDataFromUrl(TMobile.URL_AUTHENTICATE, basicAuthToken);

        Gson gson = new Gson();
        AuthToken authToken = gson.fromJson(authenticationData, AuthToken.class);

        return authToken.response.authToken;
    }

    protected static List<Profile> parseProfiles(JsonObject jsonProfiles) {
        List<Profile> profiles = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> keys = jsonProfiles.entrySet();
        ArrayList<Map.Entry<String, JsonElement>> profileIds = new ArrayList<>(keys);

        for (int i = 0; i < profileIds.size(); i++) {
            String profileId = profileIds.get(i).getKey();
            JsonObject jsonProfile = jsonProfiles.get(profileId).getAsJsonObject();
            String roleName = jsonProfile.get("roleName").getAsString();

            Profile profile = new Profile();
            profile.setId(profileId);
            profile.setRoleName(roleName);

            //Process billing account
            BillingAccount billingAccount = extractBillingAccount(jsonProfile);
            profile.setBillingAccount(billingAccount);
            //End of billing account

            //Process balance
            JsonObject jsonBillingAccount = jsonProfile.getAsJsonObject("billingAccount");

            Balance balance = extractBalance(jsonBillingAccount);
            billingAccount.setBalance(balance); //Set it in the billing account
            //End of balance

            //Process subscriptions
            List<Subscription> subscriptions = parseSubscriptions(jsonBillingAccount.getAsJsonObject("subscriptions"));
            billingAccount.setSubscriptions(subscriptions);
            //End of subscriptions

            profiles.add(profile);
        }

        return profiles;
    }

    protected static List<Subscription> parseSubscriptions(JsonObject jsonSubscriptions) {
        List<Subscription> subscriptions = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> keys = jsonSubscriptions.entrySet();
        ArrayList<Map.Entry<String, JsonElement>> subscriptionIds = new ArrayList<>(keys);

        for (int i = 0; i < subscriptionIds.size(); i++) {
            String subscriptionId = subscriptionIds.get(0).getKey();

            JsonObject jsonSubscription = jsonSubscriptions.get(subscriptionId).getAsJsonObject();

            Subscription subscription = new Subscription();
            subscription.setPhoneNumber(subscriptionId);
            subscription.setCallUsageLink(jsonSubscription.get("callUsageLink").getAsString());
            subscription.setContractEndDate(jsonSubscription.get("contractEndDate").getAsString());
            subscription.setDataUsageLink(jsonSubscription.get("dataUsageLink").getAsString());
            subscription.setInfoLink(jsonSubscription.get("infoLink").getAsString());
            subscription.setPaymentType(jsonSubscription.get("paymentType").getAsString());
            subscription.setTariffName(jsonSubscription.get("tariffName").getAsString());
            subscription.setTrafficSOC(jsonSubscription.get("tariffSOC").getAsString());
            subscription.setThirdPartyUsageLink(jsonSubscription.get("thirdPartyUsageLink").getAsString());

            subscriptions.add(subscription);
        }

        return subscriptions;
    }

    protected static CallUsageResponse buildCallUsage(String jsonCallUsage) {
        Gson gson = new Gson();

        CallUsageResponse callUsageResponse = gson.fromJson(jsonCallUsage, CallUsageResponse.class);

        return callUsageResponse;
    }

    protected static DataUsageResponse buildDataUsage(String jsonDataUsage) {

        Gson gson = new Gson();
        DataUsageResponse dataUsageResponse = gson.fromJson(jsonDataUsage, DataUsageResponse.class);

        return dataUsageResponse;
    }
}
