package review.thread.extendsThread;

public class BeepPrintThread {
    public static void main(String[] args) {

        Thread thread = new WorkerThread();
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}

        }

    }
}
