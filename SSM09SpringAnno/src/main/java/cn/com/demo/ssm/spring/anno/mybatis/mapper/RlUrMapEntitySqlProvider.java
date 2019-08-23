package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import cn.com.demo.ssm.spring.anno.mybatis.entity.RlUrMapEntity;

public class RlUrMapEntitySqlProvider {

    public String insertSelective(RlUrMapEntity record) {
        BEGIN();
        INSERT_INTO("dm_rl_ur_map");
        
        if (record.getMpUrId() != null) {
            VALUES("mp_ur_id", "#{mpUrId,jdbcType=INTEGER}");
        }
        
        if (record.getMpRlId() != null) {
            VALUES("mp_rl_id", "#{mpRlId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }
}