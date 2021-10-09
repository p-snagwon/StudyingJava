package chap12.sec05;

public class TargetThread extends Thread {

    //CPU 스케줄러에의해서 실행대기상태와 실행상태를 번갈아가면서 작업을 진행한다.
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) { }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}

        for (int i = 0; i < 1000000000; i++) { }
    }
}
