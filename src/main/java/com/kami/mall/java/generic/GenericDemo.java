package com.kami.mall.java.generic;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzi
 * @date 2021-07-05 1:54 PM
 */
public class GenericDemo {

    @Test
    public void test1() {
        User u1 = User.builder()
                .id(1)
                .name("zhangsan")
                .age(18)
                .build();

        User u2 = User.builder()
                .id(2)
                .name("lisi")
                .age(20)
                .build();
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        String s1 = JSONObject.toJSONString(list);

        List list1 = JSONObject.parseObject(s1, List.class);
        System.out.println(list1);
        Object o = list1.get(0);
        System.out.println("o:" + o);


        List<User> users = JSONObject.parseObject(s1, new TypeReference<List<User>>() {
        });
        System.out.println(users);


    }
}
