package com.seu.cwg.Bean;

import java.io.Serializable;
import java.util.Date;

public class JobBean implements Serializable {

    public static final String STATUS_SCHED = "SCHED";
    public static final String STATUS_WAIT_SCHED = "WATI_SCHED";
    public static final String STATUS_PAUSED = "PAUSED"; // 暂停
    public static final String STATUS_WAIT_PAUSED = "WAIT_PAUSED";
    public static final String STATUS_RESUME = "RESUME"; // 暂停
    public static final String STATUS_WAIT_RESUME = "WAIT_RESUME";


    public static final String STATUS_DELETE = "DELETE"; // 删除
    public static final String STATUS_WAIT_DELETE = "WAIT_DELETE";

    public static final int CONFIG_MODIFIED_YES = 1;
    public static final int CONFIG_MODIFIED_NO = 0;

    public static final int CONFIG_RESET_YES = 1;
    public static final int CONFIG_RESET_NO = 0;


    private Integer id;
    private String jobName;
    private String jobGroup;
    private String jobBeanClass;
    private String cronExpression;
    private String data;
    private String status;
    private String jobDescription;
    private Integer timeoutMin;
    private Date createTime;
    private Integer isModify;
    private String alarmEmail;
    private Integer successCount;
    private Integer failCount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getJobName() {
        return jobName;
    }



    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobBeanClass() {
        return jobBeanClass;
    }

    public void setJobBeanClass(String jobBeanClass) {
        this.jobBeanClass = jobBeanClass;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getTimeoutMin() {
        return timeoutMin;
    }

    public void setTimeoutMin(Integer timeoutMin) {
        this.timeoutMin = timeoutMin;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    public String getAlarmEmail() {
        return alarmEmail;
    }

    public void setAlarmEmail(String alarmEmail) {
        this.alarmEmail = alarmEmail;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }


    @Override
    public String toString() {
        return "JobBean{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobBeanClass='" + jobBeanClass + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", status='" + status + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", timeoutMin=" + timeoutMin +
                ", createTime=" + createTime +
                ", isModify=" + isModify +
                ", alarmEmail='" + alarmEmail + '\'' +
                ", successCount=" + successCount +
                ", failCount=" + failCount +
                ", data='" + data + '\'' +
                '}';
    }
}
