package me.vncnliu.jvm;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 * jvm options:-XX:PermSize=10M -XX:MaxPermSize=10M
 */

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    public static void main(String[] args){
        try {
            //使用List保持着常量池引用，避免Full GC回收常量池行为
            List<String> list = new ArrayList<>();
            //10MB的PermSize在integer范围内足够产生OOM了
            int i = 0;
            while(true){
                list.add(String.valueOf(i++).intern());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}