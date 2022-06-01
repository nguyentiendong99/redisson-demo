package com.example.redissondemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "redis.redisson")
public class RedissonProperties {

    private String name;
    private String serverUrlSingle;
    private String severUrlSentinel;
    private String authentication;
    private String masterName;
    private int connectionTimeout;
    private int timeout;
    private int masterPoolSize;
    private int masterIdlSize;
    private int slavePoolSize;
    private int slaveIdle;
}
