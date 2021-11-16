package 재귀용법;

public class Factorial4 {

    public int factorial(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        } else {
            return factorial(n - 1) + factorial(n - 2) + factorial(n - 3);
        }
    }

    public static void main(String[] args) {

        Factorial4 factorial4 = new Factorial4();


        System.out.println(        factorial4.factorial(4));
    }
}
