package cn.com.demoall.ssm.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.com.demoall.ssm.entity.OrderEntity;

public class OrderEntitySqlProvider {

    public String insertSelective(OrderEntity record) {
        BEGIN();
        INSERT_INTO("dm_order");
        
        if (record.getOdId() != null) {
            VALUES("od_id", "#{odId,jdbcType=INTEGER}");
        }
        
        if (record.getOdUrId() != null) {
            VALUES("od_ur_id", "#{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdName() != null) {
            VALUES("od_name", "#{odName,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderEntity record) {
        BEGIN();
        UPDATE("dm_order");
        
        if (record.getOdUrId() != null) {
            SET("od_ur_id = #{odUrId,jdbcType=INTEGER}");
        }
        
        if (record.getOdName() != null) {
            SET("od_name = #{odName,jdbcType=VARCHAR}");
        }
        
        WHERE("od_id = #{odId,jdbcType=INTEGER}");
        
        return SQL();
    }
}