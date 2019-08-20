package cn.com.demo.ssm.spring.service.impl;

import cn.com.demo.ssm.spring.service.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollaborator {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("demoCollaborator.xml");
        IUserService userService = ctx.getBean(IUserService.class);
        userService.verify("zhangsan", "12345");
    }
}
