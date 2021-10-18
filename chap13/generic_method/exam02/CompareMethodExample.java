package chap13.generic_method.exam02;

public class CompareMethodExample {

    public static void main(String[] args) {

        Pare<Integer, String> p1 = new Pare<>(10, "사과");
        Pare<Integer, String> p2 = new Pare<>(10, "사과");

        boolean result1 = Util.<Integer, String>compare(p1, p2);
        if (result1) {
            System.out.println("논리적으로 동등한 객체입니다.");

        } else {
            System.out.println("논리적으로 동등하지 않은 객체 입니다.");
        }

    }
}
