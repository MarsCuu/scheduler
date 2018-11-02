package com.seu.cwg.RPC;

import com.seu.cwg.Bean.JobRecord;

public interface JobInfoService {

    public String updateState(String UUID, String state);

    public String updateJobRecord(String UUID, JobRecord jobRecord);



}
