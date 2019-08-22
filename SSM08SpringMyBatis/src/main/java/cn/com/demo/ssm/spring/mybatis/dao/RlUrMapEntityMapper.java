package cn.com.demo.ssm.spring.mybatis.dao;

import cn.com.demo.ssm.spring.mybatis.entity.RlUrMapEntity;
import org.apache.ibatis.annotations.Param;

public interface RlUrMapEntityMapper {
    int deleteByPrimaryKey(@Param("mpUrId") Integer mpUrId, @Param("mpRlId") Integer mpRlId);

    int insert(RlUrMapEntity record);

    int insertSelective(RlUrMapEntity record);
}