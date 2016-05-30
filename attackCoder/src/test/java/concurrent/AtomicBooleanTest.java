package concurrent;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/30.
 */
public class AtomicBooleanTest {

    AtomicBoolean flag = new AtomicBoolean(true);

    @Test
    public void main(){
        CountDownLatch main = new CountDownLatch(1);//控制子线程等待主线程
        ChangeValue changeValue1 = new ChangeValue("first",main);
        ChangeValue changeValue2 = new ChangeValue("second",main);
        changeValue1.start();
        changeValue2.start();
        main.countDown();
    }

    class ChangeValue extends Thread{

        private String name;
        CountDownLatch main = null;

        public ChangeValue(String name,CountDownLatch main) {
            this.name = name;
            this.main = main;
        }

        @Override
        public void run() {
            try {
                this.main.await();
                Random random = new Random();
                System.out.println(Thread.currentThread().getId()+""+flag);
                boolean result = flag.compareAndSet(true,false);
                System.out.println("compareAndSet"+result);
                if(result){
                    System.out.println(Thread.currentThread().getId());
                    System.out.println(name+" is working");
                    //Thread.sleep(random.nextInt(1000));
                    System.out.println(name+" is end");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void init(){
        AtomicBoolean init = new AtomicBoolean(true);
        System.out.println(init.compareAndSet(true,false));
    }

}
