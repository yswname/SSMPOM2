package cn.com.demo.ssm.spring.mybatis.dao;

import cn.com.demo.ssm.spring.mybatis.entity.CardEntity;

public interface CardEntityMapper {
    int deleteByPrimaryKey(Integer icId);

    int insert(CardEntity record);

    int insertSelective(CardEntity record);

    CardEntity selectByPrimaryKey(Integer icId);

    int updateByPrimaryKeySelective(CardEntity record);

    int updateByPrimaryKey(CardEntity record);
}