package com.dongzhic.annotation;

import org.apache.ibatis.type.Alias;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author dongzhic
 * @Date 2022/4/12 22:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
public @interface MyAnnotation {

    @AliasFor(attribute = "location")
    String value() default "";

    @AliasFor(attribute = "value")
    String location() default "";
}
