package concurrent;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/6/1.
 */
public class AtomicIntegetFieldUpdateTest {

    AtomicUpdate atomicUpdate = new AtomicUpdate();
    AtomicIntegerFieldUpdater<AtomicUpdate> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(AtomicUpdate.class,"field");

    @Test
    public void main() throws InterruptedException {
        Thread add = new Add();
        add.start();
        Thread decr = new Decr();
        decr.start();
        add.join();
        decr.join();
        System.out.println(atomicUpdate.field);
        System.out.println(atomicUpdate.intField);
    }

    class Add extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                atomicUpdate.intField++;
                fieldUpdater.incrementAndGet(atomicUpdate);
            }
        }
    }

    class Decr extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                atomicUpdate.intField--;
                fieldUpdater.decrementAndGet(atomicUpdate);
            }
        }
    }

    class AtomicUpdate{
        public volatile int field = 0;
        public int intField = 0;
    }
}
