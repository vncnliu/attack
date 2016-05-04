package common;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/4/15.
 */
public class TestLightQueueSyncedCopy {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch main = new CountDownLatch(1);//控制子线程等待主线程
        for (int i = 0; i < 10; i++) {
            ThreadProducer producer = new ThreadProducer(main);
            producer.start();
        }
        for (int i = 0; i < 10; i++) {
            ThreadConsumer consumer = new ThreadConsumer(main);
            consumer.start();
        }
        main.countDown();
        System.out.println(LightQueueSynced.getQueueList().size());
        System.out.println(LightQueueSynced.getQueueList());
    }

    @Test
    public void testOne() throws InterruptedException {
        CountDownLatch main = new CountDownLatch(1);//控制子线程等待主线程
        for (int i = 0; i < 10; i++) {
            ThreadProducer producer = new ThreadProducer(main);
            producer.start();
        }
        for (int i = 0; i < 10; i++) {
            ThreadConsumer consumer = new ThreadConsumer(main);
            consumer.start();
        }
        Thread.sleep(10000);
        main.countDown();
        System.out.println(LightQueueSynced.getQueueList().size());
        System.out.println(LightQueueSynced.getQueueList());
    }



    class ThreadProducer extends Thread {

        CountDownLatch main = null;

        public ThreadProducer(CountDownLatch main) {
            this.main = main;
        }

        @Override
        public void run() {
            try {
                this.main.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LightQueueSynced.queue("test");
        }
    }

    class ThreadConsumer extends Thread {

        CountDownLatch main = null;

        public ThreadConsumer(CountDownLatch main) {
            this.main = main;
        }

        @Override
        public void run() {
            try {
                this.main.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LightQueueSynced.pollFirst());
        }
    }
}
