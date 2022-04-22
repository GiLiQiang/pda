package com.liqiang.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liqiang.Apply;
import com.liqiang.service.ESManngerService;
import com.liqiang.utils.ESClient;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class ESManngerServiceImpl implements ESManngerService {
    private RestHighLevelClient client= ESClient.getClient();
    //所操作的索引
    private String index="pda";
    //声明使用的类型
    private String type="apply";

    //ObjectMapper mapper=ObjectMapper();  es自带的把对象转json字符串的工具，构造方法是默认访问修饰符，所以不可访问
    ObjectMapper mapper=new ObjectMapper();  //把对象转json
    @Override
    public void creatIndex() throws IOException {
        Settings.Builder settings=Settings.builder();
        settings.put("number_of_shards",3);
        settings.put("number_of_replicas",1);

        XContentBuilder xContentBuilder = JsonXContent.contentBuilder();
        xContentBuilder.startObject()
                            .startObject("properties")
                                .startObject("applyName")
                                    .field("type","text")
                                    .field("analyzer","ik_max_word")
                                    .field("index",true)
                                    .field("store",false)
                                .endObject()
                                .startObject("applyTime")
                                    .field("type","keyword")
                                .endObject()
                                .startObject("inTime")
                                    .field("type","keyword")
                                .endObject()
                                .startObject("types")
                                    .field("type","text")
                                    .field("analyzer","ik_max_word")
                                    .field("index",true)
                                    .field("store",false)
                                .endObject()
                                .startObject("unit")
                                    .field("type","keyword")
                                .endObject()
                                .startObject("num")
                                    .field("type","long")
                                .endObject()
                            .endObject()
                        .endObject();

        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        
        createIndexRequest.settings(settings);
        
        createIndexRequest.mapping(type,xContentBuilder);
        
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        


    }

    @Override
    public boolean indexExists() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest();
        getIndexRequest.indices(index);
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);


        return exists;
    }

    @Override
    public boolean deleateIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();
        deleteIndexRequest.indices(index);
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        return delete.isAcknowledged();
    }

    @Override
    public String addDocument() throws IOException {
        List<Apply> list=new ArrayList<Apply>();
        Apply apply=new Apply("djx","2022-3-8","20220309","服装","集装箱",100);
        Apply apply2=new Apply("bbb","2022-3-8","20220309","服装","集装箱",100);
        Apply apply3=new Apply("ccc","2022-3-8","20220309","服装","集装箱",100);
        Apply apply4=new Apply("ddd","2022-3-8","20220309","服装","集装箱",100);
        list.add(apply);
        list.add(apply2);
        list.add(apply3);
        list.add(apply4);
        //将数据转换为json格式
        String json = mapper.writeValueAsString(apply);
        //准备请求对象    参数1 操作的索引  参数2 操作的类型   参数3 手动指定ID
        IndexRequest indexRequest = new IndexRequest(index, type, apply.getApplyName());

        //参数1  写入文档的数据
        indexRequest.source(json, XContentType.JSON);

        //通过连接将请求对象发送出去

        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);


        return index.getResult().toString();
    }
}
