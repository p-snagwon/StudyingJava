package review.stream.match;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MatchExample {

    public static void main(String[] args) {

        int[] intArr = {1, 2, 3};

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0);
        System.out.println("모두 2의 배수 인가? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a %3 == 0);
        System.out.println("3의 배수가 없는가? " + result);
    }
}
