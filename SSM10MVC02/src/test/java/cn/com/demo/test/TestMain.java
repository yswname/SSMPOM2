package cn.com.demo.test;

import cn.com.demo.test.servlet.IServlet;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestMain {
    // 模拟Tomcat
    public static void main(String[] args) {
        ServiceLoader<IServlet> serviceLoader = ServiceLoader.load(IServlet.class);

        Iterator<IServlet> servlets = serviceLoader.iterator();
        // 初始化Servlet对象（响应/hello）
        IServlet servlet = null;
        if (servlets.hasNext()) {
            servlet = servlets.next();
        }
        // 执行service
        servlet.service();
    }
}
