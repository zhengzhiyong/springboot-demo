package com.springboot.craftsman.pool;

import java.util.concurrent.*;

public class FlexibleThreadPoolExecutor {
    /**
     * 队列阈值，超过此值则扩大线程池
     */
    private static final int MAX_QUEUE_SIZE = 100;

    /**
     * 每次扩(缩)容自动增加(减少)线程数
     */
    private static final int PER_THREAD_COUNT = 10;

    /**
     * 监控积压时间频率
     */
    private static final int MONITOR_DELAY_TIME = 1;

    /**
     * 以jvm内存使用率80%为界
     */
    private static final double MEMORY_USAGE = 0.8;

    private ScheduledExecutorService scheduledExecutorService ;

    private ThreadPoolExecutor executor ;

    public void start(){
        executor =new ThreadPoolExecutor(10, 100,
                60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue());

        //scheduledExecutorService = new ScheduledThreadPoolExecutor(10, new BasicThreadFactory.Builder().namingPattern("mq-monitor-schedule-pool-%d").daemon(true).build());
        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程池状态！"+executor);
                //当队列大小超过限制，且jvm内存使用率小于80%时扩容，防止无限制扩容
                if(executor.getQueue().size() >= MAX_QUEUE_SIZE && executor.getPoolSize()< executor.getMaximumPoolSize() && getMemoryUsage()<MEMORY_USAGE){
                    System.out.println("线程池扩容！"+executor);
                    executor.setCorePoolSize(executor.getPoolSize() + PER_THREAD_COUNT);
                }
                //当队列大小小于限制的80%，线程池缩容
                if(executor.getPoolSize() > 0  && executor.getQueue().size() < MAX_QUEUE_SIZE * MEMORY_USAGE  ){
                    System.out.println("线程池缩容！"+executor);
                    executor.setCorePoolSize(executor.getPoolSize() - PER_THREAD_COUNT);
                }
            }
        }, MONITOR_DELAY_TIME, MONITOR_DELAY_TIME, TimeUnit.SECONDS);
    }

    public void stop() throws InterruptedException {
        executor.shutdown();
        while (!executor.awaitTermination(1,TimeUnit.SECONDS)){
            //等待线程池中任务执行完毕
        }
        scheduledExecutorService.shutdown();
    }

    public <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    public Future<?> submit(Runnable task) {
        return executor.submit(task);
    }


    /**
     * 获取jvm内存使用率
     * @return
     */
    public static double getMemoryUsage() {
        return (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / Runtime.getRuntime().maxMemory();
    }

    public static void main(String[] args) throws InterruptedException {
        FlexibleThreadPoolExecutor pool = new FlexibleThreadPoolExecutor();
        pool.start();
        for (int i = 0; i < 1000; i++) {
            pool.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread()+" execute!~~");
                    try {
                        Thread.sleep(1500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        pool.stop();
    }
}
