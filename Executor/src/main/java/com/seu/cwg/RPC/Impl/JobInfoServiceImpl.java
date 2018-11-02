package com.seu.cwg.RPC.Impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.RPC.JobInfoService;

public class JobInfoServiceImpl implements JobInfoService {
    @Reference(version = "1.0.0")
    JobInfoService jobInfoService;

    @Override
    public String updateState(String UUID, String state) {
        return null;
    }

    @Override
    public String updateJobRecord(String UUID, JobRecord jobRecord) {
        return null;
    }
}
