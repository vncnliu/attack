package me.vncnliu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 * jvm options :-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
