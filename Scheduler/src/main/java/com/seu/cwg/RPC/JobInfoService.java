package com.seu.cwg.RPC;

import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Result;

public interface JobInfoService {

    public String updateState(String UUID,String state);

    public String updateJobRecord(String UUID, JobRecord jobRecord);



}
