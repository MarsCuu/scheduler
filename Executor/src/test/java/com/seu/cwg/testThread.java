package com.seu.cwg;

import com.seu.cwg.Task.TestTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testThread {

    public static Thread[] findAllThreads() {
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        // 遍历线程组树，获取根线程组
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        // 激活的线程数加倍
        int estimatedSize = topGroup.activeCount() * 2;
        Thread[] slacks = new Thread[estimatedSize];
        //获取根线程组的所有线程
        int actualSize = topGroup.enumerate(slacks);
        Thread[] threads = new Thread[actualSize];
        System.arraycopy(slacks, 0, threads, 0, actualSize);
        return threads;
    }
    public static void main(String[] args) {
//        new Thread("t1"){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(300000);
//                } catch (InterruptedException e) {
//                    System.out.println("t1执行中断");
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//        new Thread("t2"){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(300000);
//                } catch (InterruptedException e) {
//
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
//        Thread[] threads = findAllThreads();
//        for(Thread t : threads){
//            System.out.println(t.getName());
//            if(t.getName().equals("t1")){
//                t.interrupt();
//            }
//        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("任务提交");
        executorService.submit(new TestTask());


    }
}
