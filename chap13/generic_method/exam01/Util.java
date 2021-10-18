package chap13.generic_method.exam01;


public class Util {

    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }
}
