package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import cn.com.demo.ssm.spring.anno.mybatis.entity.RoleEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleEntityMapper {
    @Select({
            "select",
            "rl.*",
            "from dm_role rl, dm_rl_ul_map mp",
            "where mp.mp_ur_id=#{urId, jdbcType=INTEGER} and rl.rl_id=mp.mp_rl_id"
    })
    @Results(id = "RoleEntityMap", value = {
            @Result(column = "rl_id", property = "rlId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "rl_name", property = "rlName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "rl_id", property = "userList", many = @Many(select = "cn.com.demo.ssm.spring.anno.mybatis.mapper.UserEntityMapper.findByRlId", fetchType = FetchType.LAZY))
    })
    List<RoleEntity> findByUrId(Integer urId);

    @Select({
            "select",
            "rl_id, rl_name",
            "from dm_role",
            "where rl_name = #{rlName,jdbcType=VARCHAR}"
    })
    @ResultMap(value = "RoleEntityMap")
    RoleEntity findByRlName(String rlName);

    @Delete({
            "delete from dm_role",
            "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer rlId);

    @Insert({
            "insert into dm_role (rl_id, rl_name)",
            "values (#{rlId,jdbcType=INTEGER}, #{rlName,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyColumn = "rl_id", keyProperty = "rlId")
    int insert(RoleEntity record);

    @InsertProvider(type = RoleEntitySqlProvider.class, method = "insertSelective")
    int insertSelective(RoleEntity record);

    @Select({
            "select",
            "rl_id, rl_name",
            "from dm_role",
            "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    @ResultMap("RoleEntityMap")
    RoleEntity selectByPrimaryKey(Integer rlId);

    @UpdateProvider(type = RoleEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleEntity record);

    @Update({
            "update dm_role",
            "set rl_name = #{rlName,jdbcType=VARCHAR}",
            "where rl_id = #{rlId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(RoleEntity record);
}