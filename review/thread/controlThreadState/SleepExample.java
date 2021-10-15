package review.thread.controlThreadState;

import java.awt.*;

public class SleepExample {

    public static void main(String[] args) throws InterruptedException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 0; i < 10; i++) {
            toolkit.beep();

        Thread.sleep(1000);
        }


    }
}
