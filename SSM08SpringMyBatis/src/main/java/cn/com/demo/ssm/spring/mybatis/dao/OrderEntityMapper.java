package cn.com.demo.ssm.spring.mybatis.dao;

import cn.com.demo.ssm.spring.mybatis.entity.OrderEntity;

public interface OrderEntityMapper {
    int deleteByPrimaryKey(Integer odId);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    OrderEntity selectByPrimaryKey(Integer odId);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}