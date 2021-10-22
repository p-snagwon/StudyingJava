package review.lamda.argument_method_reference;

import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

public class ArgumentMethodReferencesExample {
    public static void main(String[] args) {

        ToIntBiFunction<String, String> function;

        function = (a, b) -> a.compareToIgnoreCase(b);
        print(function.applyAsInt("java8", "java8"));

        function = String :: compareToIgnoreCase;
        print(function.applyAsInt("java8", "java7"));
    }

    private static void print(int order) {
        if(order < 0) System.out.println("사전순으로 먼저 옵니다.");
        else if (order == 0) {
            System.out.println("동일한 문자열 입니다.");
        } else {
            System.out.println("사전순으로 나중에 옵니다.");
        }
    }
}
