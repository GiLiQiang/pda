package com.liqiang.frigns;

import com.liqiang.Apply;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignFallBack implements Feign {
    @Override
    public List<Apply> apply2(String name) {
        List<Apply> list = new ArrayList<>();
        return list;
    }
}
