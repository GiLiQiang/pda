package com.liqiang.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ESClient {
    public static RestHighLevelClient getClient(){
        /**
         * 创建请求对象
         */
        HttpHost httpHost = new HttpHost("127.0.0.1", 9200);
//        创建RestClientBuilder对象
        RestClientBuilder builder = RestClient.builder(httpHost);
        //创建RestHighLevelClient对象
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

        return restHighLevelClient;

    }
}
