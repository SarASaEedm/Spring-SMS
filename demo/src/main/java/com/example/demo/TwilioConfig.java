package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfig {
    private String accountSid = "AC00a5a55bf7bce79117818a1dc21f24b9";
    private String authToken = "dfcb0b7eca957ad7a0a60e19cf5ba896";
    private String trailNumber = "+18155915841";
    
    public TwilioConfig() {
    }
    public String getAccountSid() {
        return accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getTrailNumber() {
        return trailNumber;
    }

}
