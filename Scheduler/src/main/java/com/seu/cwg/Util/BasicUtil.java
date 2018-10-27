package com.seu.cwg.Util;

import com.seu.cwg.Task.BaseJob;
import org.quartz.Job;

public class BasicUtil {

    public static BaseJob getClass(String classname) throws Exception
    {
        Class<?> class1 = Class.forName(classname);
        return (BaseJob) class1.newInstance();
    }
}
