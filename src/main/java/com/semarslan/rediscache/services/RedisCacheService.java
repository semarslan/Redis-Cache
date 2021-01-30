package com.semarslan.rediscache.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod() throws InterruptedException {
        Thread.sleep(5000L);
        return "method running";
    }
    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache(){
        System.out.println("cache cleared");
    }
}
