package com.zhangziwa.practisesvr.utils.log;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ThreadMXBeanConfig implements InitializingBean {
    @Value("${thread.cpu_time_enabled:true}")
    private static boolean isThreadCpuTimeEnabled;
    @Value("${thread.allocated_memory_enabled:true}")
    private static boolean isThreadAllocatedMemoryEnabled;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (isThreadCpuTimeEnabled) {
            ThreadMXBeanUtils.setThreadCpuTimeEnabled(true);
        }
        if (isThreadAllocatedMemoryEnabled) {
            ThreadMXBeanUtils.setThreadAllocatedMemoryEnabled(true);
        }
    }
}
