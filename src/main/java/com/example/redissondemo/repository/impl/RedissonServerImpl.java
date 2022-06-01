package com.example.redissondemo.repository.impl;

import com.example.redissondemo.repository.RedissonServer;
import org.redisson.api.RMapCache;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedissonServerImpl<T> implements RedissonServer<T> {
    private final RedissonClient client;

    public RedissonServerImpl(RedissonClient client) {
        this.client = client;
    }

    @Override
    public void setRMap(String mapCache, String key, T value) {
        RMapCache<String, T> rMapCache = client.getMapCache(mapCache);
        rMapCache.put(
                key,
                value,
                20L,
                TimeUnit.MINUTES
        );
    }

    @Override
    public T getRMap(String mapCache, String key, Class<T> clazz) {
        RMapCache<String, T> rMapCache = client.getMapCache(mapCache);
        return rMapCache.get(key);
    }

    @Override
    public void setRMap(String mapCache, String key, T value, long timeLive, TimeUnit timeUnit) {
        RMapCache<String, T> rMapCache = client.getMapCache(mapCache);
        rMapCache.put(
                key,
                value,
                timeLive,
                timeUnit
        );
    }

    @Override
    public void removeSession(String sessionMap, String onboardingId) {
        client.getMapCache(sessionMap).remove(onboardingId);
    }
}
