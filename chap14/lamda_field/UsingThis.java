package chap14.lamda_field;

public class UsingThis {

    public int field = 10;

    class Inner {
        int field = 20;

        void method(){

            MyFunctionalInterface fi = () -> {
                System.out.println("outerfield: " + UsingThis.this.field);
                System.out.println("innerfield: " + field);
            };
            fi.method();
        }
    }
}
