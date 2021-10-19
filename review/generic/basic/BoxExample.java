package review.generic.basic;

public class BoxExample {

    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.setT("hello");
        String str = box1.getT();


        Box<Integer> box2 = new Box<>();
        box2.setT(100);
        Integer value = box2.getT();

    }
}
