package com.zhangziwa.practisesvr.utils.log;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LogContext {
    private static ThreadLocal<AtomicInteger> sql_count = new InheritableThreadLocal<>();
    private static ThreadLocal<AtomicLong> sql_cost = new InheritableThreadLocal<>();
    private static ThreadLocal<String> traceid = new InheritableThreadLocal<>();
    private static ThreadLocal<Long> acclocated_memory = new InheritableThreadLocal<>();
    private static ThreadLocal<Long> total_cpu_cost = new InheritableThreadLocal<>();
    private static ThreadLocal<Long> user_cpu_cost = new InheritableThreadLocal<>();

    public static void initSqlCount() {
        sql_count.set(new AtomicInteger(0));
    }

    public static void incrementSqlCount() {
        if (sql_count.get() == null) {
            sql_count.set(new AtomicInteger(0));
        }
        sql_count.get().incrementAndGet();
    }

    public static int getSqlCount() {
        return sql_count.get().intValue();
    }

    public static void initSqlCost() {
        sql_cost.set(new AtomicLong(0));
    }

    public static void incrementSqlCost(Long sqlCost) {
        if (sql_cost.get() == null) {
            sql_cost.set(new AtomicLong(0));
        }
        sql_cost.get().addAndGet(sqlCost);
    }

    public static Long getSqlCost() {
        return sql_cost.get().longValue();
    }

    public static void setTraceId(String traceId) {
        if (traceid.get() == null) {
            traceid.set(traceId);
        }
    }

    public static String getTraceId() {
        return traceid.get();
    }

    public static void initAllocatedBytes() {
        acclocated_memory.set(ThreadMXBeanUtils.getCurrentThreadAllocatedBytes());
    }

    public static void initCurrentThreadTime() {
        total_cpu_cost.set(ThreadMXBeanUtils.getCurrentThreadTime());
    }

    public static void initCurrentThreadUserTime() {
        user_cpu_cost.set(ThreadMXBeanUtils.getCurrentThreadUserTime());
    }

    public static void clear() {
        sql_count.remove();
        sql_cost.remove();
        traceid.remove();
        acclocated_memory.remove();
        total_cpu_cost.remove();
        user_cpu_cost.remove();
    }
}
