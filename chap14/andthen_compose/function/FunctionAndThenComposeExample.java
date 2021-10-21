package chap14.andthen_compose.function;

import chap14.andthen_compose.consumer.Address;
import chap14.andthen_compose.consumer.Member;

import java.util.function.Function;

public class FunctionAndThenComposeExample {

    public static void main(String[] args) {

        Function<Member, Address> functionA;
        Function<Address, String> functionB;
        Function<Member, String> functionAB;

        functionA = (m) -> m.getAddress();
        functionB = (m) -> m.getCity();
        functionAB = functionA.andThen(functionB);

        String city = functionAB.apply(
                new Member("홍길동",new Address("한국", "서울")));

        System.out.println("거주 도시:" + city);


        functionAB = functionB.compose(functionA);
        city = functionAB.apply(new Member("홍길동", new Address("한국", "서울")));
        System.out.println("거주 도시: " + city);

    }
}
