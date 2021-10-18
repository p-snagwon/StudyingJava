package chap13.genericType;

public class BoxExample {
    public static void main(String[] args) {

        Box<String> box = new Box<>();

        box.setT("generic");
        String t = box.getT();

        Box<Integer> box2 = new Box<>();
    }
}
