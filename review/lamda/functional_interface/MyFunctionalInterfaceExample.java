package review.lamda.functional_interface;

import review.lamda.annotation_functional_interface.MyFunctionalInterface;

public class MyFunctionalInterfaceExample {

    public static void main(String[] args) {

        MyFunctionalInterface fi;

        fi = () -> {
            String str = "mehtod call";
            System.out.println(str);

        };

        fi.method();

        fi = () -> {
            System.out.println("method call2");
        };
        fi.method();

        fi = () -> System.out.println("method call3");
        fi.method();
    }
}
