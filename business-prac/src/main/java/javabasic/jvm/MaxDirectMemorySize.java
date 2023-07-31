package jvm;


//import jdk.internal.access.SharedSecrets;
//import jdk.internal.misc.VM;

import java.lang.management.BufferPoolMXBean;
import java.lang.management.ManagementFactory;

public class MaxDirectMemorySize {
//    public static void main(String[] args) {
//
//        printJVMRuntime();
//        printDirectMemory();
//
//        System.out.println("分配25M本地字节缓冲区 " + ByteBuffer.allocateDirect(25 * 1024 * 1024));
//        System.out.println("创建10M对象 " + new byte[10 * 1024 * 1024]);
//
//        printJVMRuntime();
//        printDirectMemory();
//
//        System.out.println("分配25M本地字节缓冲区 " + ByteBuffer.allocateDirect(25 * 1024 * 1024));
//        System.out.println("创建10M对象 " + new byte[10 * 1024 * 1024]);
//
//        printJVMRuntime();
//        printDirectMemory();
//    }

    private static void printJVMRuntime() {
        System.out.println("java虚拟机从操纵系统那里挖到的最大的内存   maxMemory " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("java虚拟机已经从操作系统那里挖过来的内存   totalMemory : " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println("java虚拟机从操纵系统挖过来还没用上的内存   freeMemory : " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
    }

//    private static void printDirectMemory() {
//        System.out.println("the maximum allocatable direct buffer memory: " + VM.maxDirectMemory() / 1024 / 1024 + "M");
//
//        System.out.println("BufferPoolMXBean.Name: " + getDirectBufferPoolMBean().getName());
//        System.out.println("BufferPoolMXBean.Count: " + getDirectBufferPoolMBean().getCount());
//        System.out.println("BufferPoolMXBean.TotalCapacity: " + getDirectBufferPoolMBean().getTotalCapacity() / 1024 / 1024 + "M");
//        System.out.println("BufferPoolMXBean.MemoryUsed: " + getDirectBufferPoolMBean().getMemoryUsed() / 1024 / 1024 + "M");
//
//        System.out.println("BufferPool.Name: " + getNioBufferPool().getName());
//        System.out.println("BufferPool.Count: " + getNioBufferPool().getCount());
//        System.out.println("BufferPool.TotalCapacity: " + getNioBufferPool().getTotalCapacity() / 1024 / 1024 + "M");
//        System.out.println("BufferPool.MemoryUsed: " + getNioBufferPool().getMemoryUsed() / 1024 / 1024 + "M");
//    }

    public static BufferPoolMXBean getDirectBufferPoolMBean() {
        return ManagementFactory.getPlatformMXBeans(BufferPoolMXBean.class).stream().filter(e -> e.getName().equals("direct")).findFirst().orElseThrow();
    }

//    public static VM.BufferPool getNioBufferPool() {
//        return SharedSecrets.getJavaNioAccess().getDirectBufferPool();
//    }
}