package chap14.method_reference;

import java.util.function.IntBinaryOperator;

public class MethodReferenceExample {

    public static void main(String[] args) {

        IntBinaryOperator operator;

        //정적 메소드 참조
        operator = (x, y) -> Calculator.staticMethod(x, y);
        System.out.println("결과1: " + operator.applyAsInt(1, 2));

        operator = Calculator :: staticMethod;
        System.out.println("결과1: " + operator.applyAsInt(3, 4));


        //인스턴스메서드 참조

        Calculator obj = new Calculator();
        operator = (x, y) -> obj.instanceMethod(x, y);
        System.out.println("결과2: " + operator.applyAsInt(2, 3));

        operator = obj :: instanceMethod;
        System.out.println("결과2: " + operator.applyAsInt(2, 3));

    }
}
