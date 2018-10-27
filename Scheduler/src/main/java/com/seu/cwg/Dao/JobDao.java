package com.seu.cwg.Dao;

import com.seu.cwg.Bean.JobBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JobDao {

    String TABLE_NAME = "job_bean";
    String INSERT_FIELD = "jobName,jobGroup,jobBeanClass,cronExpression,data,status,jobDescription,timeoutMin,createTime,isModify,alarmEmail,successCount,failCount";
    String SELECT_FIELD = "jobName,jobGroup,jobBeanClass,cronExpression,data,status,jobDescription,timeoutMin,createTime,isModify,alarmEmail,successCount,failCount";
    @Insert({"insert into ",TABLE_NAME,"(",INSERT_FIELD ,") values(#{jobName},#{jobGroup},#{jobBeanClass},#{cronExpression},#{data},#{status},#{jobDescription},#{timeoutMin},#{createTime},#{isModify},#{alarmEmail},#{successCount},#{failCount})"})
    int addJob(JobBean jobBean);

}
