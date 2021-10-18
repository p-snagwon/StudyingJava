package chap13.nonGenericType;

public class BoxExample {
    public static void main(String[] args) {

        Box box = new Box();

        box.setObject("홍길동");
        String object = (String) box.getObject();

        box.setObject(new Apple());

    }
}
