package review.thread.notify;

public class WaitNotifyExample {

    public static void main(String[] args) {
        WorkObject shareObject = new WorkObject();

        Thread threadA = new ThreadA(shareObject);
        Thread threadB = new ThreadB(shareObject);

        threadA.start();
        threadB.start();
    }
}
