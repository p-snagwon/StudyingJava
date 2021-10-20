package chap14.runnable;

import review.thread.notify.ThreadA;

public class RunnableExample {

    public static void main(String[] args) {

        /*Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
*/


        Thread thread = new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
            }
        });
        thread.start();
    }
}
