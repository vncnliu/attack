package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/30.
 */
public class BTraceTest{
    public int add(int a,int b){
        return a+b;
    }
    public static void main(String[]args)throws IOException

    {
        BTraceTest test=new BTraceTest();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++){
            reader.readLine();
            int a=(int)Math.round(Math.random()*1000);
            int b=(int)Math.round(Math.random()*1000);
            System.out.println(test.add(a,b));
        }
    }
}

/*@BTrace
public class TracingScript{
    @OnMethod(
    clazz="org.fenixsoft.monitoring.BTraceTest",
    method="add",
    location=@Location(Kind.RETURN)
            )
    public static void func(@Self org.fenixsoft.monitoring.BTraceTest instance,int a,int b,@Return int result){
        println("调用堆栈：");
        jstack();
        println(strcat("方法参数A：",str(a)));
        println(strcat("方法参数B：",str(b)));
        println(strcat("方法结果：",str(result)));
    }
}*/


