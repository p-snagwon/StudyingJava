package review.stream.parallel_stream;

import java.util.Arrays;
import java.util.List;

public class SequencialVsParallelExample {
    public static void work(int value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //순차처리
    public static long testSequncial(List<Integer> list) {
        long startTime = System.nanoTime();
        list.stream().forEach(a -> work(a));
        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        return runTime;
    }

    //병렬처리
    public static long testParallel(List<Integer> list) {

        long startTime = System.nanoTime();
        list.stream().parallel().forEach(a -> work(a));
        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        return runTime;
    }

    public static void main(String[] args) {
        //소스컬렉션
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 6, 7);

        //순차스트림 처리 시간 구하기
        long timeSequential = testSequncial(list);

        //병렬 스트림 처리 시간 구하기
        long timeParallel = testParallel(list);

        if (timeSequential < timeParallel) {
            System.out.println("순차처리 시간이 더빠름");

        } else {
            System.out.println("병렬 처리 시간이 더빠름");
        }


    }
    }

    //요소처리




