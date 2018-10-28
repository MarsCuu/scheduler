package com.seu.cwg.Service;

import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Task.BaseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class JobService {

    @Autowired
    ExecutorService executorService;

    public void exeTask(JobRecord jobRecord){
        try {
            Class clazz = Class.forName(jobRecord.getJobBeanClass());
            BaseTask bs = (BaseTask) clazz.newInstance();
            bs.setJobRecord(jobRecord);
            executorService.submit(bs);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
