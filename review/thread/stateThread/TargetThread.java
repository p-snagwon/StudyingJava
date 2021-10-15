package review.thread.stateThread;

public class TargetThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            System.out.println("d");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) { }

        }
    }
}
