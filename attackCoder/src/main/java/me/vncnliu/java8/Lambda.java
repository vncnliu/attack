package me.vncnliu.java8;

import java.util.Arrays;

/**
 * Copyright (c) 2008 by vncnliu.
 * All right reserved.
 * Created by vncnliu@gmail.com on 2016/5/3.
 */
public class Lambda {
    public static void main(String[] args) {
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println( e ) );
        String a = "a";
        System.out.println(Integer.toHexString(a.hashCode()));
        String b = "a";
        System.out.println(Integer.toHexString(b.hashCode()));
    }
}
