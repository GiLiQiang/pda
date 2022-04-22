package com.liqiang.service.impl;

import com.liqiang.RabbitMq;
import com.liqiang.service.GetMqService;
import com.rabbitmq.client.*;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class GetMqServiceImpl implements GetMqService {
    @Override
    public void getMq() {
        Connection connection = RabbitMq.getConnection();

        Channel channel = null;

        try {
            channel = connection.createChannel();
            //参数1：队列的名字
            //参数2：队列里的消息是否持久化,true为持久化，
            //参数3：是否被多个消费者消费 false 被一个消费者消费
            //参数4：是否自动删除消息---消费者宕机后，造成无消费者时，不删除，堆积
            //参数5：是否有其他额外的消息，null   无
            channel.queueDeclare("liqiang1",true,false,false,null);
            channel.basicQos(1);
            Channel channel1 = channel;
            DefaultConsumer consumer = new DefaultConsumer(channel1){
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    // no work to do
                    String f = new String(body);

                    channel1.basicAck(envelope.getDeliveryTag(),false);
                }
            };

            channel.basicConsume("liqiang1",false,consumer);
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

    }
}
