package review.thread.ConsumerAndProducerThread_fixing;

public class DataBox {

    private String data;

    public synchronized String getData() {
        if (this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        String returnValue = data;
        System.out.println("ConsumerThread가 읽은 데이터: " + returnValue);
        data = null;
        notify();
        return returnValue;
    }

    public synchronized void setData(String data) {
        if (this != null) {
            try {
                wait();
            } catch (InterruptedException e) { }

        }
        System.out.println(data);
        this.data = data;
        System.out.println("ProducerThread가 생성한 데이터" + this.data);
        notify();
    }
}
