package com.kami.mall.test;

import com.kami.mall.entity.DO.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author yangzi
 * @date 2021-06-25 11:19 PM
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@PropertySource(value = {"demo.properties"})
public class SpringBootTestDemo {

    @Autowired
    private User user;

    @Test
    public void test1() {
        System.out.println(user);
    }

    @Test
    public void test2() {
        Person p = new Person();
        System.out.println(p.getAge());
        System.out.println(p.getSize());
        System.out.println(p.getFlag());
    }

    @Test
    public void test3() {
        long nowTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        long nowAgo = LocalDateTime.now().minusSeconds(1000).toInstant(ZoneOffset.of("+8")).toEpochMilli();

        System.out.println("nowTime : " + nowTime);
        System.out.println("nowAgo : " + nowAgo);

        if (nowTime > nowAgo) {
            System.out.println("nowTime 更大");
        } else {
            System.out.println("nowAgp 更大");
        }
    }
}
