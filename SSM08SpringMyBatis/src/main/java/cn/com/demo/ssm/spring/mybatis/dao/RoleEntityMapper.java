package cn.com.demo.ssm.spring.mybatis.dao;

import cn.com.demo.ssm.spring.mybatis.entity.RoleEntity;

import java.util.List;

public interface RoleEntityMapper {
    List<RoleEntity> findByUrId(Integer urId);

    int deleteByPrimaryKey(Integer rlId);

    int insert(RoleEntity record);

    int insertSelective(RoleEntity record);

    RoleEntity selectByPrimaryKey(Integer rlId);

    int updateByPrimaryKeySelective(RoleEntity record);

    int updateByPrimaryKey(RoleEntity record);
}