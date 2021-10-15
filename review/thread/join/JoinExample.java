package review.thread.join;

public class JoinExample {

    public static void main(String[] args) {

        SumThread sumThread = new SumThread();
        sumThread.start();

//        System.out.println("1~100까지의 합: " + sumThread.getSum());

        try {
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1~100까지의 합: " + sumThread.getSum());

    }
}
