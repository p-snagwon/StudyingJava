package chap12.sec02.createThread;

import java.awt.*;

public class BeepThread extends Thread{
    // 스레드클래스를 상속받아서 하위스레드를 만들어서 사용하는 경우

    @Override
    public void run() {
        //비프음을 5번 반복해서 내는 작업
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
