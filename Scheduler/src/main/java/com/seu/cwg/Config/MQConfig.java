package com.seu.cwg.Config;

import com.rabbitmq.client.ConnectionFactory;
import com.seu.cwg.MQ.Sender;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public Queue testQueue() {
        return new Queue("testQueue");
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("Linux", true, false);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(testQueue()).to(exchange()).with("LinuxCmd");
    }

    @Bean("sender")
    Sender sender(){
        return new Sender();
    }
}


