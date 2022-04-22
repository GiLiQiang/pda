package com.liqiang.service;

import com.liqiang.Apply;

import java.util.List;

public interface ApplyService {
    List<Apply> findApply(String name);

    void removeByName(String name);
}
