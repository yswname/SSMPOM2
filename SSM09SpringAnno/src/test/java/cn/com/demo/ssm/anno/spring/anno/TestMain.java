package cn.com.demo.ssm.anno.spring.anno;

import cn.com.demo.ssm.anno.spring.anno.config.DemoSpringAnnoConfig;
import cn.com.demo.ssm.anno.spring.anno.service.IDemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DemoSpringAnnoConfig.class);
        IDemoService demoService = ctx.getBean(IDemoService.class);
//        demoService.business();
        demoService.business("zhangsan", "123456");
    }
}
