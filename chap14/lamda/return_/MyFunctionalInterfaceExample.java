package chap14.lamda.return_;


public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        MyFunctionalInterface fi;

        fi = (x, y) -> {
            int result  = x + y;
            return result;
        };

        System.out.println(fi.method(2,3));
    }
}
