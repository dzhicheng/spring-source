package com.dongzhic.tomcat;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class LoadServletImpl implements LoadServlet {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        // servlet加入到tomcat上下文
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", "com.dongzhic.servlet.InitServlet");
        // 指定tomcat启动就加载，值>=0时，随着tomcat启动
        // 对应servlet标签：<load-on-startup></load-on-startup>
        initServlet.setLoadOnStartup(1);
        // 对应web.xml标签：<servlet-mapping></servlet-mapping>
        initServlet.addMapping("/init");
    }
}
