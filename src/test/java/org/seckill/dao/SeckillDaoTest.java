package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
/*
* 配置spring和junit整合，junit启动加载时加载springIOC容器
* spring-test
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现类依赖
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> list = seckillDao.queryAll(0,100);
        for (Seckill seckill : list){
            System.out.println(seckill);
        }
    }

    @Test
    public void reduceNumber() {
        Date date = new Date();

        int updateCount = seckillDao.reduceNumber(1000L,date);
        System.out.println("updateCount = " + updateCount);
    }
}