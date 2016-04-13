package me.vncnliu.dto;

/**
 * Copyright (c) 2008 by sangame.com.
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/4/13.
 */
public class Greeting {

    private String name;
    private long id;

    public Greeting(long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
