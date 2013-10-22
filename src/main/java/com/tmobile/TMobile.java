package com.tmobile;

import com.tmobile.data.CallUsageResponse;
import com.tmobile.data.CallRecord;
import com.tmobile.data.DataUsageResponse;
import com.tmobile.data.DataRecord;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static com.tmobile.TMobileParsing.*;
import com.tmobile.data.Profile;
import com.tmobile.data.Subscription;
import java.io.IOException;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

public class TMobile {

    private static final String URL_TMOBILE = "https://www.t-mobile.co.uk";
    private static final String URL_USER_INFO = URL_TMOBILE + "/mtmapis/restws/v1.0/user-info/";
    protected static final String URL_AUTHENTICATE = URL_TMOBILE + "/mtmapis/restws/v1.0/authenticate/";

    private String authToken;
    private String basicAuthToken;

    private TMobile(String username, String password) throws IOException {
        this.authToken = getToken(username, password);
        basicAuthToken = Base64.encodeBase64String(String.valueOf(username + ":" + authToken).getBytes());
    }

    public static TMobile login(String username, String password) throws IllegalArgumentException {
        try {
            //TODO: Check the response from getToken before creating a new instance
            return new TMobile(username, password);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Unknown user - " + ex.getMessage());
        }
    }

    public List<Profile> getUserAccounts() throws IOException {
        JsonElement root = new JsonParser().parse(getDataFromUrl(URL_USER_INFO, basicAuthToken));

        JsonObject jsonProfiles = root.getAsJsonObject().get("response").getAsJsonObject().get("data").getAsJsonObject().getAsJsonObject("profiles");
        List<Profile> profiles = parseProfiles(jsonProfiles);
        return profiles;
    }

    public List<CallRecord> getCallUsage(Subscription subscription) throws IOException {

        String jsonUsageData = getDataFromUrl(subscription.getCallUsageLink(), basicAuthToken);

        CallUsageResponse callUsageResponse = buildCallUsage(jsonUsageData);
        List<CallRecord> callRecords = callUsageResponse.getCallUsage().getUsage();

        return callRecords;
    }

    public List<DataRecord> getDataUsage(Subscription subscription) throws IOException {
        String jsonUsageData = getDataFromUrl(subscription.getDataUsageLink(), basicAuthToken);

        DataUsageResponse dataUsageResponse = buildDataUsage(jsonUsageData);
        List<DataRecord> dataRecords = dataUsageResponse.getDataUsage().getDataRecords();

        return dataRecords;
    }
}
