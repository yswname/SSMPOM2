package cn.com.demoall.ssm.mapper;

import cn.com.demoall.ssm.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserEntityMapper {
    @Select("select * from dm_user")
    @Results({
            @Result(column = "ur_id", property = "urId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "ur_user_name", property = "urUserName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_name", property = "urName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_age", property = "urAge", jdbcType = JdbcType.INTEGER)
    })
    List<UserEntity> findAll();

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
    int insertSelective(UserEntity record);

    @Select({
            "select",
            "ur_id, ur_user_name, ur_name, ur_age",
            "from dm_user",
            "where ur_id = #{urId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "ur_id", property = "urId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "ur_user_name", property = "urUserName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_name", property = "urName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "ur_age", property = "urAge", jdbcType = JdbcType.INTEGER)
    })
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