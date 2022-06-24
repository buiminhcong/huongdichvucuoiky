package com.example.getwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
public class GetwayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetwayServiceApplication.class, args);
    }
//Nếu không có phương thức này, RateLimiter sẽ chặn luôn truy cập.
    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just("1");
    }

}
