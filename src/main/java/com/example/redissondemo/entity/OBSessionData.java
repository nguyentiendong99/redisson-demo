package com.example.redissondemo.entity;

import lombok.*;

import java.io.Serializable;
import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class OBSessionData implements Serializable {
    String onboardingId;
    String nextFlow;
    String mobileId;
    int currentOTP;
    HashMap<String, Object> map;

    public void put(String key, Object value) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }

    public Object get(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public void remove(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
    }

//    public OBSessionData() {
//        this.map = new HashMap<String, Object>();
//    }
}
