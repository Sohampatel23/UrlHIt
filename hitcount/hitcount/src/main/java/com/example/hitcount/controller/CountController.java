package com.example.hitcount.controller;

import com.example.hitcount.entity.UserHitResponse;
import com.example.hitcount.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

    private final CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @GetMapping("/count")
    public int getHitCount() {
        return countService.incrementHitCount();
    }

    @GetMapping("/username/{username}/count")
    public UserHitResponse getUserHitCount(@PathVariable String username) {
        int hitCount = countService.getUserHitCount(username);
        return new UserHitResponse(username, hitCount);
    }
}
