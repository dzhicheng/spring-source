package com.dongzhic.tomcat;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class LoadServletImpl1 implements LoadServlet {
    @Override
    public void loadOnstarp(ServletContext servletContext) {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet1", "com.dongzhic.servlet.InitServlet1");
        initServlet.setLoadOnStartup(1);
        initServlet.addMapping("/init1");
    }
}
