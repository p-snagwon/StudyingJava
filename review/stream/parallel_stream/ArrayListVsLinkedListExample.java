package review.stream.parallel_stream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedListExample {


    public static void work() {

    }

    //병렬처리
    public static long testParallel(List<Integer> list) {

        long startTime = System.nanoTime();
        list.stream().parallel().forEach(a -> work());
        long endTime = System.nanoTime();
        long runTime = endTime - startTime;

        return runTime;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10000000; i++) {

            arrayList.add(i);
            linkedList.add(i);
        }

        //워밍업  실행 준비과정에서 오차를 줄이기 위해서 작성
        long arrayListParallel = testParallel(arrayList);
        long LinkedListParallel = testParallel(linkedList);

        arrayListParallel = testParallel(arrayList);
        LinkedListParallel = testParallel(linkedList);

        if (arrayListParallel < LinkedListParallel) {
            System.out.println("arrayList 가 더 빠름");

        } else {
            System.out.println("LinkedList가 더빠름");
        }
    }

}
