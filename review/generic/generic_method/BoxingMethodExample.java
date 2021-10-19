package review.generic.generic_method;

public class BoxingMethodExample {

    public static void main(String[] args) {

        Box<Integer> box1 = Util.boxing(100);
        Integer intValue = box1.getT();


        Box<String> box2 = Util.boxing("홍길동");
        String strValue = box2.getT();

    }
}
