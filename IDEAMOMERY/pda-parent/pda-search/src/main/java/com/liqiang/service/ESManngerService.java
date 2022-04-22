package com.liqiang.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface ESManngerService {
    //创建索引
    void creatIndex() throws IOException;

    //判断索引是否存在
    boolean indexExists() throws IOException;

    //删除索引
    boolean deleateIndex() throws IOException;

    //添加文档
    String addDocument() throws IOException;
}
