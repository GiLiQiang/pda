package com.futurelight.mapper;

import com.futurelight.pojo.ContactInfo;

import java.util.List;

public interface ContactMapper {
    List<ContactInfo> queryAll();

    int delete(Integer[] ids);

    ContactInfo queryById(Integer id);

    int update(ContactInfo contactInfo);

    int add(ContactInfo contactInfo);
}
