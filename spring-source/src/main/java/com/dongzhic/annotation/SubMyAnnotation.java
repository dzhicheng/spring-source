package com.dongzhic.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 继承父注解的属性，使其拥有更强大的功能
 * @Author dongzhic
 * @Date 2022/4/13 10:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@MyAnnotation
public @interface SubMyAnnotation {

    @AliasFor(value = "location", annotation = MyAnnotation.class)
    String subLocation () default "";

    /**
     * 缺省指明继承的父注解的中的属性名称，则默认继承父注解中同名的属性名
     * @return
     */
    @AliasFor(annotation = MyAnnotation.class)
    String value() default "";

}
