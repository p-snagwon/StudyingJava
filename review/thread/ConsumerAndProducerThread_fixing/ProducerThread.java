package review.thread.ConsumerAndProducerThread_fixing;

public class ProducerThread extends Thread {


    private DataBox dataBox;

    public ProducerThread(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            String data = "data" + i;

            dataBox.setData(data);
        }
    }
}
