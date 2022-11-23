package com.works.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class AppBeans {

    @Bean(name = "appUuid")
    public String uuid() {
        return UUID.randomUUID().toString();
    }

}
