package cn.com.demo.ssm.spring;

import cn.com.demo.ssm.spring.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        // 创建一个Spring容器对象，对象在初始化的时候，自动读取/解析xml中的信息
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取被管理的对象（service对象）
        UserServiceImpl userService = (UserServiceImpl) ctx.getBean("userService");
        boolean bool = userService.verify("zhangsan", "123456");
        System.out.println(bool);
    }
}
