package review.lamda.using_local_variable;


public class UsingLocalVariable {

    void method(int arg) {
        int localVar = 40;

        // 람다식에서 쓰이는 매개변수와 로컬변수는 파이널 특성을 가지기 때문에 수정을 할 수가 없다.
//        localVar = 20;
//        arg = 20;

        //람다식
        MyFunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar + "\n");
        };
        fi.method();
    }
}
