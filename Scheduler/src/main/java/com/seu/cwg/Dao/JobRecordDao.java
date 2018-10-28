package com.seu.cwg.Dao;

import com.seu.cwg.Bean.JobRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JobRecordDao {


    String TABLE_NAME = "job_record";
    String INSERT_FIELD = "UUID,jobName,jobGroup,jobBeanClass,type,state,log,triggerTime,exeTime,endTime";
    String SELECT_FIELD = "UUID,jobName,jobGroup,jobBeanClass,type,state,log,triggerTime,exeTime,endTime";
    @Insert({"Insert into",TABLE_NAME,"(",INSERT_FIELD,") values(#{UUID},#{jobName},#{jobGroup},#{jobBeanClass},#{type},#{state},#{log},#{triggerTime},#{exeTime},#{endTime})" })
    void addJobRecord(JobRecord jobRecord);
}
