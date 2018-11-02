package com.seu.cwg.RPC.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Dao.JobDao;
import com.seu.cwg.RPC.JobInfoService;
import com.seu.cwg.Result;
import com.seu.cwg.Service.JobRecordService;
import com.seu.cwg.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
public class JobInfoServiceImpl implements JobInfoService {

    @Autowired
    JobRecordService jobRecordService;
    @Override
    public String updateState(String UUID, String state) {
        return JSON.toJSONString(jobRecordService.updateState(UUID,state));
    }

    @Override
    public String updateJobRecord(String UUID, JobRecord jobRecord) {
        return null;
    }
}
