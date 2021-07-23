package com.kami.mall.test;

import lombok.Data;

/**
 * @author yangzi
 * @date 2021-07-21 2:58 下午
 */
@Data
public class Person {

    private String name;

    private int age;

    private Integer size;

    private Boolean flag;

    public Person() {
    }

    public Person(String name, int age, Integer size) {
        this.name = name;
        this.age = age;
        this.size = size;
    }
}
