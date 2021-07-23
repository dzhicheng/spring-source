package com.dongzhic.annotation;

import java.lang.annotation.*;

/**
 * @Author dongzhic
 * @Date 7/14/21 3:33 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ReturnValue {
    String name() default "";
}
