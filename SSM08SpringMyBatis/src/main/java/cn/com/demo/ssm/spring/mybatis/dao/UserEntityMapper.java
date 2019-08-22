package cn.com.demo.ssm.spring.mybatis.dao;

import cn.com.demo.ssm.spring.mybatis.entity.UserEntity;

import java.util.List;

public interface UserEntityMapper {
    List<UserEntity> findByRlId(Integer rlId);

    int deleteByPrimaryKey(Integer urId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer urId);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}