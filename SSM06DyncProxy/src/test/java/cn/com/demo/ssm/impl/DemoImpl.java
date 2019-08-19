package cn.com.demo.ssm.impl;

import cn.com.demo.ssm.IDemo;
import cn.com.demo.ssm.MyLoger;

public class DemoImpl implements IDemo {
    @Override
    public void test() {
        System.out.println("111111111111111111");
        new MyLoger().log("hello how are you");
    }

    @Override
    public void test2(String name) {
        System.out.println("111111111111111111");
        new MyLoger().log(name);
    }
}
