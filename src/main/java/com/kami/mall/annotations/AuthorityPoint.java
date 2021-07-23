package com.kami.mall.annotations;

import java.lang.annotation.*;

/**
 * @author yangzi
 * @date 2021-07-13 3:06 PM
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthorityPoint {
    String[] AccessPoint();
}

