package com.liqiang.frigns;

import com.liqiang.Apply;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "APPLYCON" +
        "SUMER",fallback = FeignFallBack.class)
//@FeignClient("APPLYCONSUMER")
public interface Feign {

    @RequestMapping(value = "/query/add2/{name}",method = RequestMethod.GET)
    List<Apply> apply2(@PathVariable String name);
}
