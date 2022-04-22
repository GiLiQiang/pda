package com.futurelight.service.impl;

import com.futurelight.mapper.ContactMapper;
import com.futurelight.pojo.ContactInfo;
import com.futurelight.pojo.PageResult;
import com.futurelight.service.ContactService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public PageInfo<ContactInfo> queryAll() {
        PageHelper.startPage(1,10);
        List<ContactInfo> contactInfos = contactMapper.queryAll();
        PageInfo<ContactInfo> contactInfoPageInfo = new PageInfo<>(contactInfos,10);
        return contactInfoPageInfo;
    }

    @Override
    public boolean delete(Integer[] ids) {
        int delete = contactMapper.delete(ids);
        return delete>0;
    }

    @Override
    public ContactInfo queryById(Integer id) {
        ContactInfo contactInfo = contactMapper.queryById(id);
        return contactInfo;
    }

    @Override
    public boolean update(ContactInfo contactInfo) {
        int update = contactMapper.update(contactInfo);
        return update==1;
    }

    @Override
    public boolean add(ContactInfo contactInfo) {
        int add = contactMapper.add(contactInfo);

        return add==1;
    }

}
