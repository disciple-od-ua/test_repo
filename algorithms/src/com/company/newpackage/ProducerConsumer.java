package com.company.newpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer  {

    public static void main(String[] args) throws InterruptedException {
        mine();
    }


    private static void mine() throws InterruptedException {
        List<String> messages = new ArrayList<String>();
        Thread prodThread = new Thread(new Producer(messages, 10));
        Thread consThread = new Thread(new Consumer(messages, 10));
        Thread consThread2 = new Thread(new Consumer(messages, 10));

        prodThread.start();
        consThread.start();
        consThread2.start();

        prodThread.join();
        consThread.join();
        consThread2.join();
    }

    private static void theirs() throws InterruptedException {
        final LowLevelProducerConsumer low = new LowLevelProducerConsumer();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    low.produce();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        low.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private final List<String> MESSAGES;
    private final int SIZE;
    private final String MESSAGE_TEMPLATE = "MSG";

    public Producer(List<String> messages, int size) {
        this.MESSAGES = messages;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                produce(i);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (MESSAGES) {
            while (MESSAGES.size() == SIZE) {
                System.out.println("Cannot produce new message");
                MESSAGES.wait();
            }
            String msg = MESSAGE_TEMPLATE + i;
            MESSAGES.add(msg);
            System.out.println("Produced message: " + msg);
            MESSAGES.notifyAll();
        }
    }

}

class Consumer implements Runnable {
    private final List<String> MESSAGES;
    private final int SIZE;

    public Consumer(List<String> messages, int size) {
        this.MESSAGES = messages;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                consume();
                if (new Random().nextInt(5) == 3)
                    Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (MESSAGES) {
            while (MESSAGES.isEmpty()) {
                System.out.println("Nothing to consume");
                MESSAGES.wait();
            }
            String msg = MESSAGES.remove(0);
            System.out.println("Consumed message: " + msg);
            MESSAGES.notifyAll();
        }
    }
}
/////////////////////////////////////////////////////////////////////////////////
class LowLevelProducerConsumer {
    ArrayList<Integer> list = new ArrayList<Integer>();
    private final int SIZE = 10;
    Random r = new Random(System.currentTimeMillis());

    public synchronized void produce() {
        try {
            while (list.size() != SIZE) {
                list.add(r.nextInt(100));
            }
        } finally {
            // Notifies consumer that entries have been generated
            this.notify();
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (list.isEmpty()) {
            // Nothing to consume for now; wait for more.
            // System.err.println("Consumer waiting...");
            this.wait();
        }

        if (r.nextInt(10) == 7) { // just an arbitrary condition
            int loc = r.nextInt(list.size());
            int data = list.remove(loc);
            System.out.format(
                    "%d removed from index %d , size : %d\n",
                    data, loc, list.size());
            Thread.sleep(300);
        }
    }

}



