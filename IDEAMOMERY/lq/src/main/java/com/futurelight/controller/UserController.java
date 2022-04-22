package com.futurelight.controller;

import com.futurelight.pojo.ContactInfo;
import com.futurelight.pojo.MessageConstant;
import com.futurelight.pojo.PageResult;
import com.futurelight.pojo.Result;
import com.futurelight.service.ContactService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/contact")
public class UserController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public PageInfo<ContactInfo> queryAll(){
            return contactService.queryAll();
    }

    @RequestMapping("/queryById")
    @ResponseBody
    public Result queryById(Integer id){
        try{
            ContactInfo contactInfo = contactService.queryById(id);
            return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS,contactInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer[] ids){
        try{
            boolean delete = contactService.delete(ids);
            return new Result(delete, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(ContactInfo contactInfo){
        try{
            boolean update = contactService.update(contactInfo);
            return new Result(update, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }

    }

    @RequestMapping("/add")
    @ResponseBody
    public Result add(ContactInfo contactInfo){
        try{
            boolean add = contactService.add(contactInfo);
            return new Result(add, MessageConstant.ADD_CHECKGROUP_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_CHECKGROUP_FAIL);
        }

    }
}
