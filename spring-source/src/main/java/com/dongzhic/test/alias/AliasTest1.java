package com.dongzhic.test.alias;

import com.dongzhic.annotation.MyAnnotation;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 指定属性名设置属性值
 * @Author dongzhic
 * @Date 2022/4/13 10:05
 */
@MyAnnotation(location = "location")
public class AliasTest1 {

    @Test
    public void test () {
        MyAnnotation myAnnotation = AnnotationUtils.getAnnotation(this.getClass(), MyAnnotation.class);
        System.out.println("value=" + myAnnotation.value() + ", location=" + myAnnotation.location());
    }
}
