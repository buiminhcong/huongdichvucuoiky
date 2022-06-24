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
        twilioConfig.setAccountSid("ACbd4fa3512ad92bb410ae0c574b4915f0");
        twilioConfig.setAuthToken("88d9b5f41da1b38620b39f80b0b30ef0");
        twilioConfig.setTrialNumber("+18173826764");
        return twilioConfig;
    }
}
