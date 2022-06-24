package com.example.verifyservice.config;

import lombok.Data;

@Data
public class TwilioConfig {
    private String accountSid;
    private String authToken;
    private String trialNumber;

    public TwilioConfig() {
    }

    public TwilioConfig(String accountSid, String authToken, String trialNumber) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.trialNumber = trialNumber;
    }
}
