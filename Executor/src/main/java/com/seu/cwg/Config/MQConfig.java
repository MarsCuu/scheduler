package com.seu.cwg.Config;

import com.seu.cwg.MQ.Consumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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

    @Bean
    Consumer consumer(){return  new Consumer();}

}


