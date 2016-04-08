package me.vncnliu.algorithm;

import org.junit.Test;

import java.util.Random;

/**
 * Copyright (c) 2008 by sangame.com.
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/3/9.
 * 给定一个包含32为整数的顺序文件，至多40亿个整数，次序随机，查找一个此文件中不存在的整数
 * 内存充足情况与只有上百字节的情况
 */

public class SortNumber {

    @Test
    public void main() {

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
}
