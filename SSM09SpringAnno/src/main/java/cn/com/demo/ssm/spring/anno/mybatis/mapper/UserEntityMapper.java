package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import cn.com.demo.ssm.spring.anno.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserEntityMapper {
    @Select({
            "select",
            "ur.*",
            "from dm_user ur, dm_rl_ur_map mp",
            "where mp.mp_rl_id=#{rlId, jdbcType=INTEGER} and mp.mp_ur_id=ur.ur_id"
    })
    @Results(id = "UserEntityMap", value = {
            @Result(column = "ur_id", property = "urId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "ur_user_name", property = "urUserName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_name", property = "urName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_age", property = "urAge", jdbcType = JdbcType.INTEGER),
            @Result(column = "ur_id", property = "roleList", many = @Many(select = "cn.com.demo.ssm.spring.anno.mybatis.mapper.RoleEntityMapper.findByUrId", fetchType = FetchType.LAZY))
    })
    List<UserEntity> findByRlId(Integer rlId);

    @Delete({
            "delete from dm_user",
            "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer urId);

    @Insert({
            "insert into dm_user (ur_id, ur_user_name, ",
            "ur_name, ur_age)",
            "values (#{urId,jdbcType=INTEGER}, #{urUserName,jdbcType=VARCHAR}, ",
            "#{urName,jdbcType=VARCHAR}, #{urAge,jdbcType=INTEGER})"
    })
    int insert(UserEntity record);

    @InsertProvider(type = UserEntitySqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "urId", keyColumn = "ur_id")
    int insertSelective(UserEntity record);

    @Select({
            "select",
            "ur_id, ur_user_name, ur_name, ur_age",
            "from dm_user",
            "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    @ResultMap("UserEntityMap")
    UserEntity selectByPrimaryKey(Integer urId);

    @UpdateProvider(type = UserEntitySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserEntity record);

    @Update({
            "update dm_user",
            "set ur_user_name = #{urUserName,jdbcType=VARCHAR},",
            "ur_name = #{urName,jdbcType=VARCHAR},",
            "ur_age = #{urAge,jdbcType=INTEGER}",
            "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserEntity record);
}