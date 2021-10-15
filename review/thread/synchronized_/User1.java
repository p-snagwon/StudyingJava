package review.thread.synchronized_;

import review.thread.setPriority.CalcThread;

public class User1 extends Thread {

    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        this.setName("User1");
        this.calculator = calculator;
    }


    @Override
    public void run() {
        calculator.setMemory(100);
    }
}
