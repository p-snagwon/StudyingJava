package chap16.stream_looping;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5};

        System.out.println("[peek()를 마지막에 호출한 경우");
        Arrays.stream(intArray)
                .filter(a -> a % 2 == 0)
                .peek(n -> System.out.println(n)); // peek는 중간처리 메소드이기때문에 실행되지 않는다.
        System.out.println();

        System.out.println("[peek()를 마지막에 호출한 경우");
        int total = Arrays.stream(intArray)
                .filter(a -> a % 2 == 0)
                .peek(n -> System.out.println(n))
                .sum();

        System.out.println("총합: "+ total);

    }
}
