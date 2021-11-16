package 재귀용법;

public class Factorial2 {

    public int function(int value) {
        if (value <= 1) {
            return 1;
        } else {
            return value * function(value - 1);
        }
    }

    public static void main(String[] args) {
        Factorial2 factorial = new Factorial2();


        System.out.println(        factorial.function(5));


    }
}
