package cn.com.demoall.ssm.mapper;

import cn.com.demoall.ssm.entity.RoleEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoleEntityMapper {
    @Delete({
        "delete from dm_role",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rlId);

    @Insert({
        "insert into dm_role (rl_id, rl_name)",
        "values (#{rlId,jdbcType=INTEGER}, #{rlName,jdbcType=VARCHAR})"
    })
    int insert(RoleEntity record);

    @InsertProvider(type=RoleEntitySqlProvider.class, method="insertSelective")
    int insertSelective(RoleEntity record);

    @Select({
        "select",
        "rl_id, rl_name",
        "from dm_role",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="rl_id", property="rlId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rl_name", property="rlName", jdbcType=JdbcType.VARCHAR)
    })
    RoleEntity selectByPrimaryKey(Integer rlId);

    @UpdateProvider(type=RoleEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleEntity record);

    @Update({
        "update dm_role",
        "set rl_name = #{rlName,jdbcType=VARCHAR}",
        "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleEntity record);
}