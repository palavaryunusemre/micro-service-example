package com.yep.task;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class redisCleanupTask {
    private final CacheManager cacheManager;
    @Scheduled(cron = "0 0 2 * * ?")
    public void scheduledCleanup() {
        cacheManager.getCache("upper-case").clear();
    }
}
