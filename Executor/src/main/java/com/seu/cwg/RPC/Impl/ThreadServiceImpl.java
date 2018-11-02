package com.seu.cwg.RPC.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.seu.cwg.Bean.JobRecord;
import com.seu.cwg.Bean.Result;
import com.seu.cwg.RPC.ThreadService;
import com.seu.cwg.Util.BasicUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Service(version = "1.0.0")
public class ThreadServiceImpl implements ThreadService {
//    @Override
//    public String stopThread(List<JobRecord> records) {
//        return "stop thrad";
//    }
    @Override
    public String stopThread(List<JobRecord> records) {
        List<String> toStop = new ArrayList<>();
        for(JobRecord jobRecord : records){
            toStop.add(jobRecord.getExeThread());
        }

        Thread[] threads = BasicUtil.findAllThreads();
        Result result = new Result();
        try {
            for(Thread t : threads){
                if(toStop.contains(t.getName())){
                    t.interrupt();
                }
            }
            result.setCode(1);
            result.setMsg("任务取消成功！");
        }catch (Exception e){
            result.setCode(0);
            result.setMsg("任务取消失败！");
        }

        return JSON.toJSONString(result);
    }

    //public String test(){
     //   return "testtest";
   // }
}
