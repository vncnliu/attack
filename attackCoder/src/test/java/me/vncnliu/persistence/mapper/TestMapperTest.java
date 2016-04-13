package me.vncnliu.persistence.mapper;

import me.vncnliu.web.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright (c) 2008 by sangame.com.
 * All right reserved.
 * Created by liuyaqing@sangame.com on 2016/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class TestMapperTest {

    @Resource
    private TestMapper testMapper;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {
        me.vncnliu.persistence.entity.Test test = new me.vncnliu.persistence.entity.Test();
        testMapper.insertSelective(test);
    }
}