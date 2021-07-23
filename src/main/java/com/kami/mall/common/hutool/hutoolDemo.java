package com.kami.mall.common.hutool;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.util.Calendar;

/**
 * @author yangzi
 * @date 2021-06-22 4:54 PM
 */
public class hutoolDemo {

    /**
     * Convert : 类型转换工具类，用于各种数据类型的转换
     */
    @Test
    public void test1() {

    }

    @Test
    public void test2() {
        DateTime date = DateUtil.date();

        DateTime date1 = DateUtil.date(Calendar.getInstance());
        System.out.println(date1);
        System.out.println(Calendar.getInstance());
    }
}
