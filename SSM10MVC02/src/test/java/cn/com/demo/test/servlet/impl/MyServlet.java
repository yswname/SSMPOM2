package cn.com.demo.test.servlet.impl;

import cn.com.demo.test.servlet.IServlet;

public class MyServlet implements IServlet {
    @Override
    public void service() {
        System.out.println("*******test SPI**************");
    }
}
