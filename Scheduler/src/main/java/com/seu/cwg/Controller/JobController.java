package com.seu.cwg.Controller;

import com.seu.cwg.Bean.JobBean;
import com.seu.cwg.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JobController {
    @Autowired
    JobService jobService;

    @RequestMapping("/index")
    public void test(){
        jobService.testSend();
        System.out.println("test");

    }
    @RequestMapping("/addJob")
    public void addJob(@RequestParam("jobName") String jobName,
                       @RequestParam("jobGroup") String jobGroup,
                       @RequestParam("jobBeanClass") String jobBeanClass,
                       @RequestParam("cronExpression")String cronExpression,
                       @RequestParam("data") String data,
                       @RequestParam("type") String type,
                       @RequestParam("jobDescription") String jobDescription,
                       @RequestParam("timeoutMin") Integer timeoutMin,
                       @RequestParam("alarmEmail") String alarmEmail){


        JobBean jobBean = new JobBean();
        jobBean.setJobName(jobName);
        jobBean.setJobGroup(jobGroup);
        jobBean.setCronExpression(cronExpression);
        jobBean.setJobBeanClass(jobBeanClass);
        jobBean.setData(data);
        jobBean.setType(type);
        jobBean.setStatus(JobBean.STATUS_WAIT_SCHED);
        jobBean.setJobDescription(jobDescription);
        jobBean.setTimeoutMin(timeoutMin);
        jobBean.setCreateTime(new Date());
        jobBean.setIsModify(1);
        jobBean.setAlarmEmail(alarmEmail);
        jobBean.setSuccessCount(0);
        jobBean.setFailCount(0);
        System.out.println(jobBean.toString());
        jobService.addJob(jobBean);


    }
}
