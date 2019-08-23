package cn.com.demo.ssm.spring.anno.service;

import cn.com.demo.ssm.spring.anno.mybatis.entity.UserEntity;

public interface IUserService {
    public void saveUser(UserEntity userEntity);
}
