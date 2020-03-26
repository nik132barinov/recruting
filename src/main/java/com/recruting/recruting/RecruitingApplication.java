package com.recruting.recruting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RecruitingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecruitingApplication.class, args);
    }
}
