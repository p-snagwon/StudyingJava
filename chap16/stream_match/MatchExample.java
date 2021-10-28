package chap16.stream_match;

import java.util.Arrays;

public class MatchExample {

    public static void main(String[] args) {

        int[] intArray = {2, 5, 6};

        boolean result = Arrays.stream(intArray)
                .allMatch(a -> a % 2 == 0);
        System.out.println("모두 2의 배수 인가?" + result);

        boolean result2 = Arrays.stream(intArray)
                .anyMatch(a -> a % 6 == 0);
        System.out.println("6의 배수가 있는가? " + result2);

        boolean result3 = Arrays.stream(intArray)
                .noneMatch(a -> a % 7 == 0);
        System.out.println("7의 배수가 없는가? " + result2);
    }
}
