package threadingproblems;

public class ProducerConsumer {
    private int i;

    public ProducerConsumer(int i) {
        this.i = i;
    }

    public synchronized void produce() throws InterruptedException {
        if (i > 0) {
            wait();
        }
        i++;
        System.out.println("Produced i = " + i);
        Thread.sleep(1000);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        if (i == 0) {
            wait();
        }
        System.out.println("Consumed i = " + i);
        i--;
        Thread.sleep(1000);
        notify();
    }

    public static void main(String[] args) {
        ProducerConsumer p = new ProducerConsumer(0);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        p.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                        p.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }

}
