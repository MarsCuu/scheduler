package com.seu.cwg.MQ;


import com.alibaba.fastjson.JSON;
import com.seu.cwg.Bean.JobBean;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Service.JobService;
import com.seu.cwg.Util.BasicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues="testQueue")
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @Autowired
    JobService jobService;
    @RabbitHandler
    public void process(String jobMsg) throws Exception {
        JobRecord jobRecord = JSON.parseObject(jobMsg, JobRecord.class);

        logger.info("接收到任务: "+jobRecord.getUUID());
        jobService.exeTask(jobRecord);
    }
}
