package chap12.sec04.unsynchronized;

public class User2 extends Thread{

    private Calculator calculator;

    public void setCalculator(Calculator calculator) {
        setName("UserB");
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}
