package com.liqiang.controller;

import com.liqiang.Apply;
import com.liqiang.frigns.Feign;
import com.liqiang.service.ApplyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apply")
public class ConsumerController {
    @Autowired
    private RestTemplate rest;

    @Autowired
    private Feign feign;

    @Autowired
    private ApplyService applyService;

    @GetMapping("/add")
    @HystrixCommand(fallbackMethod = "addplyFallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.strateg",value = "SEMAPHORE"), //THREAD ,默认是hystrix线程池，可以配置信号量:SEMAPHORE
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"), //配合超时时间，毫秒为单位
            @HystrixProperty(name = "execution.timeout.enabled",value = "true"),//开启超时时间
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value="100"),//设置信号量方式的线程隔离，允许某个服务多少个并发请求量
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//启用断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),//请求失败的个数
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "70"),//请求失败的百分比
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")//有open到half ofen的时间间隔
    })
    public String addply(Apply apply){
        System.out.println(apply);
        String url = "http://APPLYCONSUMER/query/add";
        String s = rest.postForObject(url, apply, String.class);
        return s;

    }
    public String addplyFallBack(Apply apply){

        List<Apply> list = new ArrayList<>();
        return "list";

    }

    @GetMapping("/add2/{name}")   //这里使用单独得RequestParam也可以
    public List<Apply> addply2(@PathVariable String name){

        List<Apply> apply = applyService.findApply(name);
        System.out.println("两次");
        List<Apply> apply1 = applyService.findApply(name);
        return apply;

    }


}
