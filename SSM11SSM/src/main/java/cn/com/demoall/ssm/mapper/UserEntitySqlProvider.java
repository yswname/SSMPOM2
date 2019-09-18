package cn.com.demoall.ssm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demoall.ssm.entity.UserEntity;

public class UserEntitySqlProvider {

    public String insertSelective(UserEntity record) {
        BEGIN();
        INSERT_INTO("dm_user");
        
        if (record.getUrId() != null) {
            VALUES("ur_id", "#{urId,jdbcType=INTEGER}");
        }
        
        if (record.getUrUserName() != null) {
            VALUES("ur_user_name", "#{urUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrName() != null) {
            VALUES("ur_name", "#{urName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrAge() != null) {
            VALUES("ur_age", "#{urAge,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(UserEntity record) {
        BEGIN();
        UPDATE("dm_user");
        
        if (record.getUrUserName() != null) {
            SET("ur_user_name = #{urUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrName() != null) {
            SET("ur_name = #{urName,jdbcType=VARCHAR}");
        }
        
        if (record.getUrAge() != null) {
            SET("ur_age = #{urAge,jdbcType=INTEGER}");
        }
        
        WHERE("ur_id = #{urId,jdbcType=INTEGER}");
        
        return SQL();
    }
}