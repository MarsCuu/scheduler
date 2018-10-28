package com.seu.cwg.Task;

import com.seu.cwg.Bean.JobBean;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public class HelloJob implements BaseJob {

    private final static Logger logger = LoggerFactory.getLogger(HelloJob.class);
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        logger.info("hello job execute " + new Date());
        System.out.println((JobBean)context.getMergedJobDataMap().get("jobBean"));
        System.out.println("Hello Job");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("hello job end" + new Date());

    }
}
