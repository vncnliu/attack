package common;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/4/15.
 */
public class TestLightQueueConcurrent {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch main = new CountDownLatch(1);
        CountDownLatch part = new CountDownLatch(20);
        for (int i = 0; i < 10; i++) {
            ThreadProducer producer = new ThreadProducer(main,part);
            producer.start();
        }
        for (int i = 0; i < 10; i++) {
            ThreadConsumer consumer = new ThreadConsumer(main,part);
            consumer.start();
        }
        Thread.sleep(10000);
        main.countDown();
        part.await();
        System.out.println(LightQueueConcurrent.getQueueList().size());
        System.out.println(LightQueueConcurrent.getQueueList());
    }


    class ThreadProducer extends Thread {

        CountDownLatch main = null;
        CountDownLatch part = null;
        public ThreadProducer(CountDownLatch main, CountDownLatch part) {
            this.main = main;
            this.part = part;
        }

        @Override
        public void run() {
            try {
                this.main.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LightQueueConcurrent.queue("test");
            part.countDown();
        }
    }

    class ThreadConsumer extends Thread {

        CountDownLatch main = null;
        CountDownLatch part = null;
        public ThreadConsumer(CountDownLatch main, CountDownLatch part) {
            this.main = main;
            this.part = part;
        }

        @Override
        public void run() {
            try {
                this.main.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LightQueueConcurrent.pollFirst());
            part.countDown();
        }
    }
}
