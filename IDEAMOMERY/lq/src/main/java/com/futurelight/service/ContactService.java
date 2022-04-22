package com.futurelight.service;

import com.futurelight.pojo.ContactInfo;
import com.futurelight.pojo.PageResult;
import com.github.pagehelper.PageInfo;

public interface ContactService {
    PageInfo<ContactInfo> queryAll();

    boolean delete(Integer[] ids);

    ContactInfo queryById(Integer id);

    boolean update(ContactInfo contactInfo);

    boolean add(ContactInfo contactInfo);
}
