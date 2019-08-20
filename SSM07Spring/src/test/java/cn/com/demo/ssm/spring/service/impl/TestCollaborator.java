package cn.com.demo.ssm.spring.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollaborator {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("demoCollaborator.xml");
        UserServiceImpl userService = ctx.getBean(UserServiceImpl.class);
        System.out.println(userService);
        userService.verify("zhangsan", "12345");
    }
}
