package com.kami.mall.java.comons.lang3;

import com.kami.mall.java.generic.User;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.io.Serializable;
import java.util.Map;

/**
 * @author yangzi
 * @date 2021-07-05 2:46 PM
 */
public class PairDemo {

    @Test
    public void test() {
        Pair<String, User> pair = Pair.of("user对象", new User(001, "lisi", 18));
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        System.out.println(pair.getLeft());
        System.out.println(pair.getRight());
    }
}

