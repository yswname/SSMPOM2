package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demo.ssm.spring.anno.mybatis.entity.CardEntity;

public class CardEntitySqlProvider {

    public String insertSelective(CardEntity record) {
        BEGIN();
        INSERT_INTO("dm_icard");
        
        if (record.getIcId() != null) {
            VALUES("ic_id", "#{icId,jdbcType=INTEGER}");
        }
        
        if (record.getIcCode() != null) {
            VALUES("ic_code", "#{icCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIcAddress() != null) {
            VALUES("ic_address", "#{icAddress,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(CardEntity record) {
        BEGIN();
        UPDATE("dm_icard");
        
        if (record.getIcCode() != null) {
            SET("ic_code = #{icCode,jdbcType=VARCHAR}");
        }
        
        if (record.getIcAddress() != null) {
            SET("ic_address = #{icAddress,jdbcType=VARCHAR}");
        }
        
        WHERE("ic_id = #{icId,jdbcType=INTEGER}");
        
        return SQL();
    }
}