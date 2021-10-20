package chap14.lamda.no_argument_no_return;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {
        MyFunctionalInterface fi;

        fi = () -> {
            String str = "park";
            System.out.println(str);
        };

        fi.method();

        fi = () -> System.out.println("method call2");
        fi.method();
    }
}
