package chap12.sec09_submit.exam02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(
                //현재 CPU개수만큼 스레드를 생성
                Runtime.getRuntime().availableProcessors()
        );

        System.out.println("작업 처리 요청");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 10; i++) {
                    sum += i;
                }

               // int error = Integer.parseInt("삼");
                System.out.println("처리 결과: " + sum);
            }
        };


        Future future = executorService.submit(runnable);

        //결과값이 아니라 지연완료객체이다.
        //작업이 완료될떄까지 지연 즉 블로킹 상태로 있다가 작업이 완료되면 블로킹이 풀리게 된다.
        try {
            future.get();
            System.out.println("작업처리 완료");
        } catch (Exception e) {
            System.out.println("예외가 발생함" + e.getMessage());
        }

        //스레드풀에 있는 작업이 모두종료가 되면 스레드풀을 종료하는 메소드
        executorService.shutdown();
    }
}
