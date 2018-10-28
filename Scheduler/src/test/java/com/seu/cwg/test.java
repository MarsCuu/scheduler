package com.seu.cwg;

import com.alibaba.fastjson.JSON;
import com.seu.cwg.Bean.JobBean;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {

    public static void main(String[] args) {
        JobBean jobBean = new JobBean();
        jobBean.setType("Linux");
        jobBean.setJobName("name");
        jobBean.setJobGroup("default");

        String str = JSON.toJSONString(jobBean);
        System.out.println(str);
        System.out.println((JSON.parseObject(str,JobBean.class)));

        ExecutorService executorService = Executors.newCachedThreadPool();
       // executorService.
    }
}
