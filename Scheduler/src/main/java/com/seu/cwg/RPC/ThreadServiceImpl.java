package com.seu.cwg.RPC;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class ThreadServiceImpl {
    @Reference(version = "1.0.0")
    ThreadService threadService;

    public String test(){
        return threadService.test();
    }
}
