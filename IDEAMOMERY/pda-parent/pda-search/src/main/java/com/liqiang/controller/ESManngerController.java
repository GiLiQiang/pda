package com.liqiang.controller;

import com.liqiang.service.ESManngerService;
import com.liqiang.service.impl.ESManngerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/search")
public class ESManngerController {
    @Autowired
    private ESManngerService esManngerService = new ESManngerServiceImpl();

    @GetMapping("/creat")
    public String creatIndex(){
        String result = "";

        try {
            esManngerService.creatIndex();
            result="创建索引成功";
        } catch (IOException e) {
            e.printStackTrace();
            result="创建索引失败";
        }catch (Exception e){
            e.printStackTrace();
            result="创建索引异常";
        }
        return result;
    }

    @GetMapping("/exists")
    public String exists(){
        String result = "";

        try {
            boolean b = esManngerService.indexExists();
            if (b){
                result="该索引已经被创建";
            }else {
                result="该索引未被创建";
            }


        } catch (IOException e) {
            e.printStackTrace();
            result="判断索引是否存在出现异常";
        }
        return result;
    }

    @GetMapping("/delete")
    public String delete(){
        String result = "";

        try {
            boolean b = esManngerService.deleateIndex();
            if (b){
                result="该索引删除成功";
            }else {
                result="该索引删除失败";
            }


        } catch (IOException e) {
            e.printStackTrace();
            result="判断删除索引是否成功出现异常";
        }
        return result;
    }

    @GetMapping("/save")
    public String save(){
        String result = "";

        try {
            esManngerService.addDocument();

                result="写入成功";

        } catch (IOException e) {
            e.printStackTrace();
            result="写入失败";
        }
        return result;
    }
}
