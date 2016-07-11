package concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/6/1.
 */
public class AtomicIntegerTest {

    private int count = 0;
    private AtomicInteger atomicCount = new AtomicInteger(0);

    @Test
    public void main() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int length = 200;
        CountDownLatch child = new CountDownLatch(length);
        for (int i = 0; i < length; i++) {
            ToAdd add = new ToAdd(countDownLatch,child);
            add.start();
        }
        countDownLatch.countDown();
        child.await();
        System.out.println(count);
        System.out.println(atomicCount);
    }

    class ToAdd extends Thread{

        CountDownLatch main;
        CountDownLatch child;

        public ToAdd(CountDownLatch main, CountDownLatch countDownLatch) {
            this.main = main;
            this.child = countDownLatch;
        }

        @Override
        public void run() {
            try {
                this.main.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                count++;
                atomicCount.getAndIncrement();
            }
            this.child.countDown();
        }
    }
}
