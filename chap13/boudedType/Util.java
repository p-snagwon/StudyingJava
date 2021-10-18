package chap13.boudedType;

public class Util {

    //Number이거나 Number의 하위클래스만 올 수 있고 메소드는 Number에만 있는 메소드만 쓸 수 있다.
    public static <T extends Number> int compare(T t1, T t2) {

        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        //v1이 더크면 1 을 리턴  , v1이 더 작으면 -1을 리턴
        return Double.compare(v1, v2);
    }
}
