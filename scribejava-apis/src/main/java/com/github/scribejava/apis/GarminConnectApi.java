package com.github.scribejava.apis;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.OAuth1RequestToken;

public class GarminConnectApi extends DefaultApi10a {

    private static final String AUTHORIZE_URL = "https://connect.garmin.com/oauthConfirm?oauth_token=%s";
    private static final String REQUEST_TOKEN_RESOURCE = "https://connectapi.garmin.com/oauth-service/oauth/request_token";
    private static final String ACCESS_TOKEN_RESOURCE = "https://connectapi.garmin.com/oauth-service/oauth/access_token";


    protected GarminConnectApi() {
    }

    private static class InstanceHolder {
        private static final GarminConnectApi INSTANCE = new GarminConnectApi();
    }

    public static GarminConnectApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getRequestTokenEndpoint() {
        return REQUEST_TOKEN_RESOURCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return ACCESS_TOKEN_RESOURCE;
    }

    @Override
    public String getAuthorizationUrl(OAuth1RequestToken requestToken) {
        return String.format(AUTHORIZE_URL, requestToken.getToken());
    }
}