package com.example.redissondemo.util;

import com.example.redissondemo.entity.OBSessionData;
import com.example.redissondemo.repository.RedissonServer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component("Util")
public class Util {
    private static RedissonServer<OBSessionData> redissonServer;

    public Util(RedissonServer<OBSessionData> redissonServer) {
        this.redissonServer = redissonServer;
    }

    private static final String SESSION_MAP = "sessionMap";

    public static OBSessionData getTest(String onboardingID) {
        OBSessionData sessionData = redissonServer.getRMap(
                "test",
                onboardingID,
                OBSessionData.class
        );
        return sessionData;
    }
    public static void setData(String id, OBSessionData sessionData) {
        redissonServer.setRMap("test" ,id ,sessionData, 10L, TimeUnit.MINUTES);
    }
    public static void setSession(String onboardingID, HashMap<String, Object> metadata) {
        OBSessionData sessionData = new OBSessionData();
        sessionData.setOnboardingId(onboardingID);
        sessionData.setMap(metadata);
        redissonServer.setRMap(SESSION_MAP, onboardingID, sessionData, 10L, TimeUnit.MINUTES);
    }
}
