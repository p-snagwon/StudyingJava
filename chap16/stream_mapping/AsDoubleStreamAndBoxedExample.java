package chap16.stream_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample {

    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4};

        IntStream stream = Arrays.stream(intArray);
        stream.asDoubleStream().forEach(d -> System.out.println(d));

        System.out.println();

        stream = Arrays.stream(intArray);
        stream.boxed().forEach(obj -> System.out.println(obj.intValue()));
    }
}
