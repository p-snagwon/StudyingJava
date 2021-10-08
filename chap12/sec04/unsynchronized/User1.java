package chap12.sec04.unsynchronized;

public class User1 extends Thread{

    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        setName("UserA");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(100);
    }
}
