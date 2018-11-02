package com.seu.cwg.Dao;

import com.seu.cwg.Bean.JobRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface JobRecordDao {


    String TABLE_NAME = "job_record";
    String INSERT_FIELD = "UUID,jobName,jobGroup,jobBeanClass,type,state,log,triggerTime,exeTime,endTime,executor,exeThread";
    String SELECT_FIELD = "UUID,jobName,jobGroup,jobBeanClass,type,state,log,triggerTime,exeTime,endTime,executor,exeThread";
    @Insert({"Insert into",TABLE_NAME,"(",INSERT_FIELD,") values(#{UUID},#{jobName},#{jobGroup},#{jobBeanClass},#{type},#{state},#{log},#{triggerTime},#{exeTime},#{endTime},#{executor},#{exeThread})" })
    void addJobRecord(JobRecord jobRecord);


    @Update({"Update",TABLE_NAME,"set state =#{state} where UUID = #{UUID}"})
    int updateState(String UUID,String state);
}
