package com.zhangziwa.practisesvr.utils.log;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;

public class ThreadMXBeanUtils {
    private static final ThreadMXBean threadMXBean = (ThreadMXBean) ManagementFactory.getThreadMXBean();

    public static void setThreadCpuTimeEnabled(boolean enabled) {
        threadMXBean.setThreadCpuTimeEnabled(enabled);
    }

    public static void setThreadAllocatedMemoryEnabled(boolean enabled) {
        threadMXBean.setThreadAllocatedMemoryEnabled(enabled);
    }

    public static Boolean isThreadCpuTimeEnabled() {
        return threadMXBean.isThreadCpuTimeEnabled();
    }

    public static Boolean isThreadAllocatedMemoryEnabled() {
        return threadMXBean.isThreadAllocatedMemoryEnabled();
    }

    public static long getCurrentThreadTime() {
        return threadMXBean.getCurrentThreadCpuTime() / 1_000_000L;
    }

    public static long getCurrentThreadUserTime() {
        return threadMXBean.getCurrentThreadUserTime() / 1_000_000L;
    }

    public static long getCurrentThreadAllocatedBytes() {
        return threadMXBean.getCurrentThreadAllocatedBytes();
    }
}
