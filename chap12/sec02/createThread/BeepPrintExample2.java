package chap12.sec02.createThread;

import java.awt.*;

public class BeepPrintExample2 {

    public static void main(String[] args) throws InterruptedException {

        //how1
//        Runnable beepTask = new BeepTask();
//        Thread thread = new Thread(beepTask);
//        thread.start();

        //how2 익명객체를 이용
        /*Thread thread = new Thread(new Runnable() {
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
        });*/


        //how3

        Thread thread = new Thread(() -> {

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
        });
        thread.start();


        //띵을 5번 출력하는 작업
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            Thread.sleep(500);
        }
    }
}
