package review.lamda.static_method.isEqual;

import java.util.function.Predicate;

public class predicateIsEqualExample {

    public static void main(String[] args) {

        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null" + predicate.test(null));

        predicate = Predicate.isEqual("java8");
        System.out.println("null, null" + predicate.test(null));


        predicate = Predicate.isEqual(null);
        System.out.println("null, null" + predicate.test("java8"));

        predicate = Predicate.isEqual("Java8");
        System.out.println("java8, java8: " + predicate.test("java8"));
    }
}
