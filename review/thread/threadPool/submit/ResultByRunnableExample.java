package review.thread.threadPool.submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResultByRunnableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");
        class Task implements Runnable {

            Result result;

            @Override
            public void run() {

                int sum = 0;

                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }

                result.addValue(sum);

            }
        }
    }

    class Result {

        int accumValue;

        synchronized void addValue(int value) {
            accumValue += value;
        }
    }

}
