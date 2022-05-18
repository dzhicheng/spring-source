package com.dongzhic.test.alias;

import com.dongzhic.annotation.SubMyAnnotation;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * @Author dongzhic
 * @Date 2022/4/13 10:19
 */
@SubMyAnnotation(subLocation = "location")
public class SubAliasTest {

    @Test
    public void test () {
        SubMyAnnotation myAnnotation = AnnotationUtils.getAnnotation(this.getClass(), SubMyAnnotation.class);
        System.out.println("value=" + myAnnotation.value() + ", location=" + myAnnotation.subLocation());
    }
}
