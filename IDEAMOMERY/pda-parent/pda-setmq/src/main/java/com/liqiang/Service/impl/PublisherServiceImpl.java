package com.liqiang.Service.impl;

import com.liqiang.RabbitMq;
import com.liqiang.Service.PublisherService;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherServiceImpl implements PublisherService {
    @Override
    public String saveMqRouting() {
        String name = "liqiang";
        Connection connection = RabbitMq.getConnection();
        Channel channel =null;
        try {
             channel = connection.createChannel();
             channel.exchangeDeclare("liqiang", BuiltinExchangeType.DIRECT);
             channel.queueBind("liqiang1","liqinag","name");
             channel.addReturnListener(new ReturnListener() {
                @Override
                public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body,"utf-8");
                    System.out.println(message+"写入队列失败");
                }
            });

            channel.confirmSelect();
            channel.basicPublish("liqiang","name",null,name.getBytes());
            try {
                channel.waitForConfirms();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
