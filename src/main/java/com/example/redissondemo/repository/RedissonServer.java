package com.example.redissondemo.repository;

import java.util.concurrent.TimeUnit;

public interface RedissonServer<T> {
    void setRMap(String mapCache, String key, T value);

    T getRMap(String mapCache, String key, Class<T> clazz);

    void setRMap(String sessionMap, String onboardingId, T sessionData, long l , TimeUnit minutes);

    void removeSession(String sessionMap, String onboardingId);
}
