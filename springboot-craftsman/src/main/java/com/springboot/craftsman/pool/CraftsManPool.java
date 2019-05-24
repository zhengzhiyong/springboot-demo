package com.springboot.craftsman.pool;

import java.util.concurrent.*;

public class CraftsManPool {

    //线程缓冲队列
    private static BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(100);

    private static BlockingQueue<Runnable> lqueue = new LinkedBlockingQueue<>();

    // 核心线程数，会一直存活，即使没有任务，线程池也会维护线程的最少数量
    private static final int CORE_SIZE = 5;

    // 线程池维护线程的最大数量
    private static final int MAX_SIZE = 10;

    // 线程池维护线程所允许的空闲时间
    private static final long ALIVE_TIME = 2000;

    private static ThreadPoolExecutor B_POOL;

    private static ThreadPoolExecutor L_POOL;
    static
    {
        B_POOL = new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE,ALIVE_TIME,TimeUnit.SECONDS,bqueue,new ThreadPoolExecutor.CallerRunsPolicy());
        L_POOL = new ThreadPoolExecutor(CORE_SIZE,MAX_SIZE,ALIVE_TIME,TimeUnit.SECONDS,lqueue,new ThreadPoolExecutor.CallerRunsPolicy());
        B_POOL.prestartAllCoreThreads();
        L_POOL.prestartAllCoreThreads();
    }

    public static ThreadPoolExecutor getBPool(){
        return B_POOL;
    }

    public static ThreadPoolExecutor getLPool(){
        return L_POOL;
    }

    public static void main(String[] args) {
        System.out.println(L_POOL.getPoolSize());
        System.out.println(B_POOL.getPoolSize());
    }
}
