package com.kami.mall.java.list;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author yangzi
 * @date 2021-07-13 10:25 AM
 */
public class ListDemo {

    @Test
    public void test() {
        String[] str = {"aa", "bb", "cc", "dd"};
        ArrayList<String> strList = Lists.newArrayList(str);
        List<String> list2 = Arrays.asList("cc", "dd", "gg", "aa");

        strList.removeAll(list2);System.out.println(strList.size() > 0);
    }
}
