package com.seu.cwg.Service;

import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Dao.JobRecordDao;
import com.seu.cwg.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobRecordService")
public class JobRecordService {
    @Autowired
    JobRecordDao jobRecordDao;


    public void addJobRecord(JobRecord jobRecord){
        jobRecordDao.addJobRecord(jobRecord);
    }

    public Result updateState(String UUID, String state){
        Result result = new Result();

        if(jobRecordDao.updateState(UUID,state)>0){
            result.setCode(1);
        }else{
            result.setCode(0);
            result.setMsg("状态修改失败");
        }
        return result;
    }
}
