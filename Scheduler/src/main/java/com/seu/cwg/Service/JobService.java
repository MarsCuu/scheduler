package com.seu.cwg.Service;

import com.seu.cwg.Bean.JobBean;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Dao.JobDao;
import com.seu.cwg.Dao.JobRecordDao;
import com.seu.cwg.MQ.Sender;
import com.seu.cwg.Util.BasicUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {
    private final Logger logger = LoggerFactory.getLogger(JobService.class);
    @Autowired@Qualifier("Scheduler")
    Scheduler scheduler;
    @Autowired
    JobDao jobDao;

    @Transactional
    public void addJob(JobBean jobBean){

            try {
                JobDetail jobDetail = JobBuilder.newJob(BasicUtil.getClass("com.seu.cwg.Task.TaskDistributed").getClass()).
                        withIdentity(jobBean.getJobName(),jobBean.getJobGroup()).build();
                jobDetail.getJobDataMap().put("jobBean",jobBean);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobBean.getCronExpression());

                CronTrigger cronTrigger = TriggerBuilder.newTrigger().
                        withIdentity(jobBean.getJobName(),jobBean.getJobGroup()).
                        withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail,cronTrigger);
                jobDao.addJob(jobBean);
            }catch (Exception e){
                e.printStackTrace();
            }

    }



    @Autowired
    Sender sender;
    public void  testSend(){
        //sender.send("Linux","LinuxCmd","helloLinux");
        //sender.send("Linux","testQueue","helloTestQueue");
        sender.send("Linux","888","hello888");
    }

}
