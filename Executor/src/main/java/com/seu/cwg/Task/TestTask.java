package com.seu.cwg.Task;

import com.seu.cwg.Util.BasicUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class TestTask extends BaseTask{
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
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println("工作线程开始工作");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread[] threads = findAllThreads();
        for(Thread t : threads){
            if(t.getName().equals(name)){
                System.out.println("工作线程即将中止");
                t.interrupt();
                System.out.println("工作线程已中止");
            }
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
