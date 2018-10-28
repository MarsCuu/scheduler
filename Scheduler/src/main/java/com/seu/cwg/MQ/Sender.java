package com.seu.cwg.MQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String exchange,String routingKey,String sendMsg){

        System.out.println("Sender send msg " + sendMsg);
        this.rabbitTemplate.convertAndSend(exchange,routingKey,sendMsg);
    }

}
