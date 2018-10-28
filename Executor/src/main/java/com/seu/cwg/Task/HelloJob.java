package com.seu.cwg.Task;

import com.seu.cwg.Bean.JobRecord;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public class HelloJob extends BaseTask {


    private final static Logger logger = LoggerFactory.getLogger(HelloJob.class);
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//
//        logger.info("hello job execute " + new Date());
//        System.out.println("Hello Job");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        logger.info("hello job end" + new Date());
//
//    }

    @Override
    public void run() {
        callBack();
        logger.info("开始执行任务："+jobRecord.getUUID());
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            logger.info("任务执行异常: "+ jobRecord.getUUID());
            e.printStackTrace();
        }

        logger.info("任务执行结束: "+ jobRecord.getUUID());
    }
}
