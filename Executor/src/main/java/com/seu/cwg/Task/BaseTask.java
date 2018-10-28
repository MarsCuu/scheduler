package com.seu.cwg.Task;

import com.seu.cwg.Bean.JobRecord;

public class BaseTask implements Runnable {
    public JobRecord jobRecord;

    public JobRecord getJobRecord() {
        return jobRecord;
    }

    public void setJobRecord(JobRecord jobRecord) {
        this.jobRecord = jobRecord;
    }

    public void callBack(){
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {

    }
}
