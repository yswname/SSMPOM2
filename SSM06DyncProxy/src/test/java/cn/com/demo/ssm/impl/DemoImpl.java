package cn.com.demo.ssm.impl;

import cn.com.demo.ssm.IDemo;
import cn.com.demo.ssm.MyLoger;

public class DemoImpl implements IDemo {
    @Override
    public void test() {
        new MyLoger().log("hello how are you");
    }

    @Override
    public void test2(String name) {
        new MyLoger().log(name);
    }
}
