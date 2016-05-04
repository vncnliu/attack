package me.vncnliu.java8;

import javax.validation.constraints.NotNull;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 */
public class FunctionInterfaceImpl implements FunctionInterface{
    @Override
    public void testjjj() {

    }

    public void testhhh(@NotNull FunctionInterfaceImpl a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        new FunctionInterfaceImpl().testjjj2("sss");
        new FunctionInterfaceImpl().testjjj2(null);
        new FunctionInterfaceImpl().testhhh(null);
    }
}
