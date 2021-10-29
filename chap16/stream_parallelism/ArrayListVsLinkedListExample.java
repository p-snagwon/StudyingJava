package chap16.stream_parallelism;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListExample {

    public static void work(int i) {

    }

    public static long testParallel (List <Integer> list) {
        long startTime =  System.nanoTime();
        list.stream().parallel().forEach((a) -> work(a));
        long endTime  = System.nanoTime();
        long runTime = endTime - startTime;
        return runTime;

    }

    public static void main(String[] args) {

        //병렬처리


        //소스 컬렉션
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        //워밍업
        long arrayListParallel = testParallel(arrayList);
        long LinkedListParallel = testParallel(linkedList);


        arrayListParallel = testParallel(arrayList);
         LinkedListParallel = testParallel(linkedList);



        if (arrayListParallel < LinkedListParallel) {
            System.out.println("성능 결과 ArrayList가 더빠름");
        } else {
            System.out.println("linkedList가 더빠름");
        }
    }
}
