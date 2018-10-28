package com.seu.cwg.Task;

import com.alibaba.fastjson.JSON;
import com.seu.cwg.Bean.JobBean;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.MQ.Sender;
import com.seu.cwg.Util.BasicUtil;
import com.seu.cwg.Util.SpringApplicationContextHolder;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


public class TaskDistributed implements BaseJob {
    private final Logger logger = LoggerFactory.getLogger(TaskDistributed.class);


//   @Autowired
//   Sender sender;
   // RabbitTemplate rabbitTemplate  = SpringApplicationContextHolder.getSpringBean("sen")
    private String routingkey;
    private String exchange = "Linux";

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
       Sender sender =(Sender) SpringApplicationContextHolder.getSpringBean("sender");

        JobBean jobBean = (JobBean)context.getMergedJobDataMap().get("jobBean");
        JobRecord jobRecord = new JobRecord();
        jobRecord.setUUID(BasicUtil.getUUID());
        jobRecord.setJobName(jobBean.getJobName());
        jobRecord.setJobGroup(jobBean.getJobGroup());
        jobRecord.setJobBeanClass(jobBean.getJobBeanClass());
        jobRecord.setType(jobBean.getType());
        jobRecord.setState("已触发");
        jobRecord.setLog(null);
        jobRecord.setTriggerTime(new Date());
        jobRecord.setEndTime(null);
        jobRecord.setEndTime(null);
        System.out.println("----------------");

        routingkey  = jobBean.getType();
        try {
            sender.send(exchange,routingkey, JSON.toJSONString(jobRecord));
            logger.info("发送任务成功："+jobRecord.getJobName()+" , "+jobRecord.getJobGroup()+" , "+jobRecord.getUUID());

        } catch (Exception e) {
            logger.info("发送任务失败："+jobRecord.getJobName()+" , "+jobRecord.getJobGroup()+" , "+jobRecord.getUUID());
            e.printStackTrace();
        }


    }
//    public void send(String exchange,String routingKey,String sendMsg){
//
//        System.out.println("Sender send msg " + sendMsg);
//        this.rabbitTemplate.convertAndSend(exchange,routingKey,sendMsg);
//    }


}
