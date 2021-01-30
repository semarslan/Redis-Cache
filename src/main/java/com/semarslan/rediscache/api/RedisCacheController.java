package com.semarslan.rediscache.api;

import com.semarslan.rediscache.services.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    private int i = 0;

    @Autowired
    private static RedisCacheService redisCacheService;

    @GetMapping
    public String cacheControl() throws InterruptedException {
        if (i == 5){
            redisCacheService.clearCache();
            i = 0;
        }
        i++;
        return redisCacheService.longRunningMethod();
    }
}
