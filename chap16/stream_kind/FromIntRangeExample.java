package chap16.stream_kind;

import java.util.stream.IntStream;

public class FromIntRangeExample {

    public static int sum = 0;
    public static int sum2 = 0;

    public static void main(String[] args) {

        //100 을 포함
        IntStream intStream = IntStream.rangeClosed(1, 100);
        intStream.forEach(a -> sum += a);
        System.out.println("1부터 100까지의 합: " + sum);


        //100을 포함하지 않음
        IntStream intStream2 = IntStream.range(1, 100);

        intStream.forEach(a -> sum2 += a);
        System.out.println("1부터 100까지의 합: " + sum2);
    }
}
