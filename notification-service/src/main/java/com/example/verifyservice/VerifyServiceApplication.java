package com.example.verifyservice;

import com.example.verifyservice.config.TwilioConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class VerifyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerifyServiceApplication.class, args);
    }
    @Bean
    public TwilioConfig tiwilioConfig() {

        TwilioConfig twilioConfig = new TwilioConfig();
        twilioConfig.setAccountSid("AC7815366b4b39930807b54cbed6f9df1c");
        twilioConfig.setAuthToken("e991c02fd4ae0f7d670cee85d05f5729");
        twilioConfig.setTrialNumber("+18597106546");
        return twilioConfig;
    }
}
