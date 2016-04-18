package common;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/4/15.
 */
public class TestLightQueueSynced {

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
        main.countDown();
        part.await();
        System.out.println(LightQueueSynced.getQueueList().size());
        System.out.println(LightQueueSynced.getQueueList());
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
            LightQueueSynced.queue("test");
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
            System.out.println(LightQueueSynced.pollFirst());
            part.countDown();
        }
    }
}
