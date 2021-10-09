package chap12.sec06.exam06_stop;

public class PrintThread2 extends Thread{

    @Override
    public void run() {

        /*try {
            while (true) {
                System.out.println("실행 중");


                Thread.sleep(1);
            }
        } catch (Exception e) { }
*/
        while (true) {
            System.out.println("실행 중");

           /* if (Thread.interrupted()) {
                break;
            }
*/
            if (isInterrupted()) {
                break;
            }
        }

    }
}
