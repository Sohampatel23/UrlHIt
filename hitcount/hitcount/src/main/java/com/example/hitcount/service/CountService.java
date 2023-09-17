package com.example.hitcount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountService {
    private Map<String, Integer> userHitCounts = new HashMap<>();
    int count =1;

    public int incrementHitCount() {
        // Implement hit count logic here
        // For simplicity, we use a single hit count for all requests
        return count++;
    }

    public int getUserHitCount(String username) {
        userHitCounts.putIfAbsent(username, 0);
        int hitCount = userHitCounts.get(username);
        userHitCounts.put(username, hitCount + 1);
        return hitCount + 1;
    }
}
