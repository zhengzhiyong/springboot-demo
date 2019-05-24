package com.springboot.craftsman.pool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;

public class ExecutorCompletionServiceManager {

    @Test
    public void test1(){
        ExecutorCompletionService service = new ExecutorCompletionService<String>(CraftsManPool.getBPool());
        for (int i = 0;i<1000;i++){
            service.submit(new ECSCallable(""+(i+1)));
        }
        try {
            for (int i = 0;i<1000;i++){
                System.out.println(service.take().get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        ExecutorCompletionService service2 = new ExecutorCompletionService<String>(CraftsManPool.getBPool());
        for (int i = 0;i<1000;i++){
            service2.submit(new ECSRunnable(""+(i+1)),String.class);
        }
        try {
            for (int i = 0;i<1000;i++){
                System.out.println(service2.take().get());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static class ECSRunnable implements Runnable{

        public ECSRunnable(String message) {
            this.message = message;
        }

        private String message;

        @Override
        public void run() {
            System.out.println("这是我对ECSRunnable说的第"+message+"句话");
        }
    }

    static class ECSCallable implements Callable<String> {

       public ECSCallable(String message) {
           this.message = message;
       }

       private String message;

       @Override
        public String call() throws Exception {
            return "这是我对ECSCallable说的第"+message+"句话";
        }
    }
}
