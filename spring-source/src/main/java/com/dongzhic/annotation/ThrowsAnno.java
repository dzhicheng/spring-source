package com.dongzhic.annotation;

import java.lang.annotation.*;

/**
 * @Author dongzhic
 * @Date 7/14/21 3:34 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ThrowsAnno {
    String name() default "";
}
