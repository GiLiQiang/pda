package com.liqiang.frigns;

import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class FeignBackFactory implements FallbackFactory<FeignFallBack> {

    @Autowired
    private FeignFallBack feignFallBack;

    @Override
    public FeignFallBack create(Throwable throwable) {
        return feignFallBack;
    }
}
