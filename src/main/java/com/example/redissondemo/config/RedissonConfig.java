package com.example.redissondemo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient getReddison() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://localhost:6379");
        singleServerConfig.setConnectionPoolSize(200);
        singleServerConfig.setConnectionMinimumIdleSize(24);
//        config.useSingleServer()
//                .setAddress()
//                .setConnectionPoolSize(10)
//                .setConnectionMinimumIdleSize(5)
//                .setConnectTimeout(30000);
        return Redisson.create(config);
    }
}
