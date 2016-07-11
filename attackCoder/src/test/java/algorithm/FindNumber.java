package algorithm;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/3/9.
 * 位图查找一定范围内不存在已知数据中的数
 */

public class FindNumber {

    @Test
    public void findUseBitMap() {

        Runtime runtime = Runtime.getRuntime();
        System.err.println(runtime.totalMemory()-runtime.freeMemory());
        boolean[] a = new boolean[10000000];
        int[] nums = bulidRandomNumList(9999990,0,9999999);
        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = true;
        }
        System.err.println(runtime.totalMemory()-runtime.freeMemory());
        for (int i = 0; i < a.length; i++) {
            if(!a[i]){
                System.out.println(i);
            }
        }
        System.err.println(runtime.totalMemory()-runtime.freeMemory());
    }

    /**
     * 生成随机的已知数据
     * @param length 数据个数
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    private int[] bulidRandomNumList(int length, int min, int max) {
        Random random = new Random();
        int[] nums = new int[length+1];
        int[] a = new int[max+1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            int ran = random.nextInt(max);
            nums[i] = a[ran];
            a[ran] = a[max];
            max--;
        }
        return nums;
    }

    @Test
    public void findWithBipartite() throws IOException {
        bulidFile();
    }

    public File bulidFile() throws IOException {

        String filePath="D:\\data\\number.txt";
        OutputStream outputStream = new FileOutputStream(filePath);
        Long  i = 1L;
        while (i<4000000000L) {
            outputStream.write(i.byteValue());
            outputStream.write(",".getBytes());
        }
        outputStream.close();
        return new File(filePath);
    }
}
