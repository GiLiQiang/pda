package com.liqiang.controller;

import com.liqiang.Apply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/query")
public class ApplyconsumerController {

    @PostMapping("/add")
    public String apply(@RequestBody Apply apply){
        int result = 1/0;
        System.out.println(apply.getApplyName());
        return "success";
    }

    @GetMapping("/add2/{name}")
    public List<Apply> apply2(@PathVariable String name){
        System.out.println(name);
        List<Apply> list=new ArrayList<Apply>();
        Apply apply=new Apply("aaa","2022-3-8","20220309","服装","集装箱",100);
        Apply apply2=new Apply("bbb","2022-3-8","20220309","服装","集装箱",100);
        Apply apply3=new Apply("ccc","2022-3-8","20220309","服装","集装箱",100);
        Apply apply4=new Apply("ddd","2022-3-8","20220309","服装","集装箱",100);
        list.add(apply);
        list.add(apply2);
        list.add(apply3);
        list.add(apply4);
        return list;
    }
}
