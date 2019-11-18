package com.basic.java.jvm;

import java.lang.management.*;
import java.util.List;

public class JvmMonitor {
    public static void main(String[] args) {
        System.out.println("===============程序运行参数==================");
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        //JVM启动参数
        System.out.println(runtimeMXBean.getInputArguments());
        //系统属性
        System.out.println(runtimeMXBean.getSystemProperties());
        //JVM名字
        System.out.println(runtimeMXBean.getVmName());

        System.out.println("===============线程状态=======================");
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //获取当前JVM内的线程数量，该指标非常重要。
        //之前遇到过用为没有对该指标进行监控而导致问题无法及时定位的情况。
        System.out.println(threadMXBean.getThreadCount());
        System.out.println(threadMXBean.getCurrentThreadCpuTime());
        System.out.println(threadMXBean.getCurrentThreadUserTime());

        System.out.println("===============类加载状态============================");
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        //获取当前JVM加载的类数量
        System.out.println(classLoadingMXBean.getLoadedClassCount());
        //获取JVM总加载的类数量
        System.out.println(classLoadingMXBean.getTotalLoadedClassCount());
        //获取JVM卸载的类数量
        System.out.println(classLoadingMXBean.getUnloadedClassCount());

        System.out.println("================系统状态======================");
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        //获取服务器的CPU个数
        System.out.println(operatingSystemMXBean.getAvailableProcessors());
        //获取服务器的平均负载。这个指标非常重要，它可以有效的说明当前机器的性能是否正常，如果load过高，说明CPU无法及时处理任务。
        System.out.println(operatingSystemMXBean.getSystemLoadAverage());

        System.out.println("================内存状态===========================");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        //获取堆内存使用情况，包括初始大小，最大大小，已使用大小等，单位字节
        System.out.println(memoryMXBean.getHeapMemoryUsage().toString());
        //获取堆外内存使用情况。
        System.out.println(memoryMXBean.getNonHeapMemoryUsage().toString());

        System.out.println("================堆内存状态======================");
        //这里会返回老年代，新生代等内存区的使用情况，按需自取就好
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        memoryPoolMXBeans.forEach((pool) -> {
            System.out.println(pool.getName());
            System.out.println(pool.getUsage());
        });

        System.out.println("===============GC状态==========================");
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        garbageCollectorMXBeans.forEach(collector -> {
            System.out.println(collector.getName());
            System.out.println(collector.getCollectionCount());
            System.out.println(collector.getCollectionTime());
        });
    }
}
