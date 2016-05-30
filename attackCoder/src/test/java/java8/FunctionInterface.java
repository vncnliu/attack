package java8;


import javax.validation.constraints.NotNull;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 */
@FunctionalInterface
public interface FunctionInterface {

    void testjjj();
    default void testjjj2(@NotNull String a){
        System.out.println(a);
    };
}
