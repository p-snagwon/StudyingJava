package review.lamda.default_method_andthen_compose;

import java.util.function.Consumer;

public class ConsumerAndThenComposeExample {

    public static void main(String[] args) {

        Consumer<Member> consumerA = (m) -> {
            System.out.println("consumerA: " + m.getName());
        };


        Consumer<Member> consumerB = (m) -> {
            System.out.println("consumerB: " + m.getId());
        };

        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}
