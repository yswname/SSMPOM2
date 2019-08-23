package cn.com.demo.ssm.spring.anno.service;

import cn.com.demo.ssm.spring.anno.config.SpringConfig;
import cn.com.demo.ssm.spring.anno.mybatis.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUserService {
    private IUserService userService;

    @Before
    public void before() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        this.userService = ctx.getBean(IUserService.class);
    }

    @Test
    public void testSave() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(13);
        userEntity.setUrName("anno03");
        userEntity.setUrUserName("01anno03");

        this.userService.saveUser(userEntity);
    }
}
