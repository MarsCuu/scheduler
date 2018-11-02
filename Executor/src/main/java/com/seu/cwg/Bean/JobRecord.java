package com.seu.cwg.Bean;

import java.io.Serializable;
import java.util.Date;

public class JobRecord implements Serializable {
    private Integer id;
    private String UUID;
    private String jobName;
    private String jobGroup;
    private String jobBeanClass;
    private String type;//已触发、已派发、已到达执行机、执行中、已完成、异常
    private String state;
    private String log;
    private Date triggerTime;
    private Date exeTime;
    private Date endTime;
    private String executor;
    private String exeThread;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobBeanClass() {
        return jobBeanClass;
    }

    public void setJobBeanClass(String jobBeanClass) {
        this.jobBeanClass = jobBeanClass;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getExeThread() {
        return exeThread;
    }

    public void setExeThread(String exeThread) {
        this.exeThread = exeThread;
    }


    @Override
    public String toString() {
        return "JobRecord{" +
                "id=" + id +
                ", UUID='" + UUID + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobBeanClass='" + jobBeanClass + '\'' +
                ", type='" + type + '\'' +
                ", state='" + state + '\'' +
                ", log='" + log + '\'' +
                ", triggerTime=" + triggerTime +
                ", exeTime=" + exeTime +
                ", endTime=" + endTime +
                ", executor='" + executor + '\'' +
                ", exeThread='" + exeThread + '\'' +
                '}';
    }
}
