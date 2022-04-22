package com.liqiang.service;

import com.liqiang.Apply;
import com.liqiang.frigns.Feign;
import com.liqiang.service.ApplyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private Feign feign;

    @Override
    @CacheResult
    @HystrixCommand(commandKey = "findApply")
    public List<Apply> findApply(@CacheKey String name) {
        return feign.apply2(name);
    }

    @Override
    @CacheRemove(commandKey = "findApply")
    @HystrixCommand
    public void removeByName(@CacheKey String name) {

    }
}
