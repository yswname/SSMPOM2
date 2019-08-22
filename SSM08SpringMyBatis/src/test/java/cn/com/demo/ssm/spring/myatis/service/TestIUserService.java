package cn.com.demo.ssm.spring.myatis.service;

import cn.com.demo.ssm.spring.mybatis.entity.RoleEntity;
import cn.com.demo.ssm.spring.mybatis.entity.UserEntity;
import cn.com.demo.ssm.spring.mybatis.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.util.ArrayList;
import java.util.List;

public class TestIUserService {
    private IUserService userService;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = ctx.getBean(IUserService.class);
    }

    @Test
    public void testSaveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUrAge(14);
        userEntity.setUrName("t测试04");
        userEntity.setUrUserName("ttest04");

        RoleEntity role = new RoleEntity();
        role.setRlName("超级管理员4");

        List<RoleEntity> roleList = userEntity.getRoleList();
        if (roleList == null) {
            roleList = new ArrayList<>();
            userEntity.setRoleList(roleList);
        }
        roleList.add(role);

        this.userService.saveUser(userEntity);
        DataSourceTransactionManager trns = null;
    }
}
