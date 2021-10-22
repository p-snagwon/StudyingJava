package review.lamda.static_method.minby_maxby;

import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {

    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        //음수일때 minby는 f1을 리턴
        binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000),new Fruit("수박", 10000));
        System.out.println(fruit.getName());


        //음수 일때 maxby는 f2를 리턴
        binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000),new Fruit("수박", 10000));
        System.out.println(fruit.getName());
    }
}
