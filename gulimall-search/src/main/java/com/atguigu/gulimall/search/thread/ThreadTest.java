package com.atguigu.gulimall.search.thread;

import com.zaxxer.hikari.util.UtilityElf;
import org.elasticsearch.search.aggregations.metrics.ParsedSingleValueNumericMetricsAggregation;

import java.util.concurrent.*;

/**
 * @Auther: gzq
 * @Date: 2021/3/28 - 03 - 28 - 10:52
 * @Description: com.atguigu.gulimall.search.thread
 */
public class ThreadTest {
   public static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main开始");
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果" + i);
//        }, executor);
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果" + i);
//            return i;
//        }, executor).whenComplete((res,exception)->{
//            System.out.println("异步任务成功完成了。。。结果是"+res+"异常是："+exception);
//        }).exceptionally(throwable -> {
//            return 10;
//        });
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 4;
//            System.out.println("运行结果" + i);
//            return i;
//        }, executor).handle((res,thr)->{
//            if (res!=null){
//                return res*2;
//            }
//            if(thr!=null){
//
//                return 0;
//            }
//            return 0;
//        });

//        .thenRunAsync(() -> {
//            System.out.println("任务2启动了");
//        }, executor);

//        .thenAcceptAsync(res->{
//            System.out.println("任务2启动了"+res);
//        },executor);

//        .thenApplyAsync(res -> {
//            System.out.println("任务2启动了" + res);
//            return "hello" + res;
//        }, executor);

        CompletableFuture<Integer> future01 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1线程：" + Thread.currentThread().getId());
            int i = 10 / 4;
            System.out.println("任务1结束");
            return i;
        }, executor);
        CompletableFuture<String> future02 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2线程：" + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
                System.out.println("任务2结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello";
        }, executor);

//        future01.runAfterBothAsync(future02,()->{
//            System.out.println("任务3开始");
//        },executor);

//        future01.thenAcceptBothAsync(future02,(f1,f2)->{
//            System.out.println("任务3开始之前的结果"+f1+"==>"+f2);
//        },executor);

//        CompletableFuture<String> future = future01.thenCombineAsync(future02, (f1, f2) -> {
//            return f1 + ":" + f2 + "-> HaHa";
//        }, executor);
//        future01.runAfterEitherAsync(future02,()->{
//            System.out.println("任务3开始之前的结果");
//        },executor);

        System.out.println("main结束");
    }

    public void thread(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("main开始");
//        Thread01 thread01 = new Thread01();
//        thread01.start();

//        Runable01 runable01 = new Runable01();
//        new Thread(runable01).start();

//        FutureTask<Integer> futureTask = new FutureTask<>(new Callable01());
//        new Thread(futureTask).start();
//        //阻塞等待
//        Integer integer = futureTask.get();
//        System.out.println("main结束"+integer);

//        service.execute(new Runable01());
//        System.out.println("main结束");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,
                200,
                10,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(100000),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

    }
    public static class  Thread01 extends  Thread{
        @Override
        public void run() {
            System.out.println("当前线程："+ Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("运行结果"+i);

        }
    }

    public static class Callable01 implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程："+ Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("运行结果"+i);
            return i;
        }
    }

    public static class Runable01 implements Runnable{
        @Override
        public void run() {
            System.out.println("当前线程："+ Thread.currentThread().getId());
            int i = 10/2;
            System.out.println("运行结果"+i);

        }
    }
}
