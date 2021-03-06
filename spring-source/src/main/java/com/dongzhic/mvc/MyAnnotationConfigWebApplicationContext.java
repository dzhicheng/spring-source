package com.dongzhic.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletException;
import java.io.File;

public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    @Override
    protected void onRefresh() {
        super.onRefresh();

        // 创建Tomcat容器
        Tomcat tomcatServer = new Tomcat();
        // 端口号设置
        tomcatServer.setPort(9090);
        // 读取项目路径    这样可以加载到静态资源
        StandardContext ctx = null;
        try {
            ctx = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());

            // 禁止重新载入
            ctx.setReloadable(false);
            // class文件读取地址    启动后 在target生成编译后的class文件
            File additionWebInfClasses = new File("target/classes");
            // 创建WebRoot
            WebResourceRoot resources = new StandardRoot(ctx);
            // tomcat内部读取Class执行
            resources.addPreResources(
                    new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
            tomcatServer.start();
            // 异步等待请求执行
            tomcatServer.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
