package me.vncnliu.web;

import me.vncnliu.config.DataSetting;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Copyright (c) 2008 by sangame.com.
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/4/8.
 */
@SpringBootApplication
@EnableConfigurationProperties(DataSetting.class)
@MapperScan("me.vncnliu.persistence.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
