package chap13.generic_method.exam01;

public class BoxingMethodExample {

    public static void main(String[] args) {

        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.getT();

        System.out.println(intValue);


        Box<String> box2 = Util.boxing("홍길동");
        String t = box2.getT();
        System.out.println(t);
    }
}
