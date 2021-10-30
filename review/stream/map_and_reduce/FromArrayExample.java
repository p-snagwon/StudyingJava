package review.stream.map_and_reduce;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayExample {

    public static void main(String[] args) {

        String[] strArray = {"홍길동", "신용권", "김나마"};

        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(a -> System.out.print(a + " "));

        System.out.println(
        );

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(i -> System.out.print(i + " "));
    }
}
