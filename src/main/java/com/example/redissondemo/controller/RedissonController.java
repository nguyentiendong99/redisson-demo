package com.example.redissondemo.controller;

import com.example.redissondemo.config.ObConstant;
import com.example.redissondemo.entity.BeautifulAcc;
import com.example.redissondemo.entity.OBSessionData;
import com.example.redissondemo.repository.RedissonServer;
import com.example.redissondemo.util.Util;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RedissonController {
    @Autowired
    private static RedissonServer<OBSessionData> redissonServer;
    @Autowired
    RedissonClient client;

    final Util util;

    public RedissonController(Util util) {
        this.util = util;
    }

    @GetMapping("/test")
    public String test() {
        HashMap<String, Object> metadata = new HashMap<>();
        String onboardingID = "nguyentiendong";
        List<BeautifulAcc> beautifulAccs = new ArrayList<>();
        BeautifulAcc beautifulAcc = new BeautifulAcc();
        beautifulAcc.setAccount("8282717182");
        BeautifulAcc beautifulAcc1= new BeautifulAcc();
        beautifulAcc1.setAccount("8282717183");
        BeautifulAcc beautifulAcc2 = new BeautifulAcc();
        beautifulAcc2.setAccount("8282717185");
        BeautifulAcc beautifulAcc3= new BeautifulAcc();
        beautifulAcc3.setAccount("82827171827");
        beautifulAccs.add(beautifulAcc);
        beautifulAccs.add(beautifulAcc1);
        beautifulAccs.add(beautifulAcc2);
        beautifulAccs.add(beautifulAcc3);
        metadata.put(ObConstant.BEAUTIFUL_ACC, beautifulAccs);
        Util.setSession(onboardingID, metadata);
        List<BeautifulAcc> getRedis = (List<BeautifulAcc>) metadata.get(ObConstant.BEAUTIFUL_ACC);
        System.out.println(getRedis);
        return "nguyen tien dong";
    }

}
