package review.thread.threadPool.Execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    ThreadPoolExecutor threadPoolExecutor =
                            (ThreadPoolExecutor) executorService;
                    int poolSize = threadPoolExecutor.getPoolSize();
                    String threadName = Thread.currentThread().getName();
                    System.out.println("총 스레드 개수: " + poolSize
                            + "작업스레드 이름 : " + threadName);

                    //예외 발생 excute로 작업을 전달했기떄문에 새로운 스레드가 작업을 진행한다.
                    int value = Integer.parseInt("삼");
                }
            };


            executorService.execute(runnable);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        executorService.shutdown();
    }
}
