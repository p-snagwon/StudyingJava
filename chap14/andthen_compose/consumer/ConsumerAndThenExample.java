package chap14.andthen_compose.consumer;

import java.util.function.Consumer;

public class ConsumerAndThenExample {

    public static void main(String[] args) {

        Consumer<Member> consumerA = (m) -> {
            System.out.println("consumerA:  "+ m.getName());

        };
        Consumer<Member> consumerB = (m) -> {
            System.out.println("consumerB: " + m.getId());
        };


        //andThen의 실행 순서: consumerA -> consumerB
        Consumer<Member> consumerAB = consumerA.andThen(consumerB);
//        consumerAB.accept(new Member("홍길동", "hong", null));
    }
}
