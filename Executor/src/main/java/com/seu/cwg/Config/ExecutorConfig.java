package com.seu.cwg.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ExecutorConfig {

    @Bean
    public ExecutorService getThreadPool(){
        return Executors.newCachedThreadPool();
    }

}
