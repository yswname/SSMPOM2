package cn.com.demoall.ssm.service;

import cn.com.demoall.ssm.entity.UserEntity;

import java.util.List;

public interface IDemoService {
    public void register(UserEntity user);

    public List<UserEntity> searchAllUsers();
}
