package chap12.sec05;

public class StatePrintThread extends Thread{

    private TargetThread targetThread;

    public StatePrintThread(TargetThread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {


        while (true) {

            Thread.State state = targetThread.getState();
            System.out.println("타겟스레드 상태: " + state);

            if (state == State.NEW) {
                targetThread.start();
            }

            if (state == State.TERMINATED) {
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }

    }
}
