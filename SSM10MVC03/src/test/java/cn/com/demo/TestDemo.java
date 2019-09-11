package cn.com.demo;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

public class TestDemo {
    public static void main(String[] args) {
        ContextLoaderListener listener;
        ServletContext ctx = null;
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ctx);
    }
}
