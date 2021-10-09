package chap12.sec04.unsynchronized;


public class Calculator {
    
    private int memory;

    public int getMemory() {
        return memory;
    }

    public synchronized void setMemory(int memory) {
        this.memory = memory;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }

        System.out.println(Thread.currentThread().getName() + ":" + this.memory);
    }

    /*
    public void setMemory(int memory) {
        this.memory = memory;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }

        System.out.println(Thread.currentThread().getName() + ":" + this.memory);
    }*/
}