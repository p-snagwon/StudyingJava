package chap12.sec06.exam02;

public class YieldExample {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }

        threadA.work = false;


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) { }

        // treadA.stop();  이런식으로 스레드를 종료해버리면 자원이 불안정한 상테에서 종료가 되기때문에 쓰지말고
        threadA.stop = true;
        threadB.stop = true;
        //필드값을 이용해서 종료시키는 것이 좋다.


    }

}
