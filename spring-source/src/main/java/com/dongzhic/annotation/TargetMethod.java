package com.dongzhic.annotation;

import java.lang.annotation.*;

/**
 * @Author dongzhic
 * @Date 7/14/21 3:15 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface TargetMethod {
    String name() default "";
}
