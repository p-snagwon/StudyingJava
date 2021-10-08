package chap12.sec02.threadName;

public class ThreadNameExample {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println("thread.getName() = " + thread.getName());

        Thread threadA = new ThreadA();
        System.out.println("ThreadA를 실행한 스레드"+ Thread.currentThread().getName());
        threadA.start();

        Thread threadB = new ThreadB();
        threadB.start();
    }
}
