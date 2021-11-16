package 재귀용법;

public class Factorial {

    public int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {

        Factorial factorial = new Factorial();

        System.out.println(        factorial.factorial(3));
    }
}
