package jvm;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 *
 */
public class TestAllocation {
    private static final int _1MB = 1024*1024;

    public static void main(String[] args) throws InterruptedException {
        //testGCDetail();
        testPretenureSizeThreshold();
    }

    /**
     * -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     */
    public static void testGCDetail(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1=new byte[2*_1MB];
        allocation2=new byte[2*_1MB];
        allocation3=new byte[2*_1MB];
        allocation4=new byte[4*_1MB];
    }

    /**
     * -Xmx20m -Xms20m -Xmn10m -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() throws InterruptedException {
        byte[] allocation1;
        allocation1=new byte[4*_1MB];
    }

}
