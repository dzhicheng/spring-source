package com.dongzhic.tomcat;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

/**
 * tomcat启动时，
 *  1.收集所有实现了ServletContainerInitializer的类
 *  2.调用onStartup方法
 * @Author dongzhic
 * @Date 7/20/21 10:33 AM
 */
@HandlesTypes(LoadServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {

    /**
     * @param set 存放实现了LoadServlet所有类的实例
     * @param servletContext servlet上下文
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator var4;
        if (set != null) {
            var4 = set.iterator();
            while (var4.hasNext()) {
                Class<?> clazz = (Class<?>) var4.next();
                if (clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers())
                        && LoadServlet.class.isAssignableFrom(clazz)) {
                    try {
                        ((LoadServlet)clazz.newInstance()).loadOnstarp(servletContext);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
