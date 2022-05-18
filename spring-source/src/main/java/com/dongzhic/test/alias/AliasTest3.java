package com.dongzhic.test.alias;

import com.dongzhic.annotation.MyAnnotation;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * 缺省属性名设置属性值
 * @Author dongzhic
 * @Date 2022/4/13 10:05
 */
@MyAnnotation("zhicheng")
public class AliasTest3 {

    @Test
    public void test () {
        MyAnnotation myAnnotation = AnnotationUtils.getAnnotation(this.getClass(), MyAnnotation.class);
        System.out.println("value=" + myAnnotation.value() + ", location=" + myAnnotation.location());
    }
}
