package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import cn.com.demo.ssm.spring.anno.mybatis.entity.CardEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CardEntityMapper {
    @Delete({
        "delete from dm_icard",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer icId);

    @Insert({
        "insert into dm_icard (ic_id, ic_code, ",
        "ic_address)",
        "values (#{icId,jdbcType=INTEGER}, #{icCode,jdbcType=VARCHAR}, ",
        "#{icAddress,jdbcType=VARCHAR})"
    })
    int insert(CardEntity record);

    @InsertProvider(type=CardEntitySqlProvider.class, method="insertSelective")
    int insertSelective(CardEntity record);

    @Select({
        "select",
        "ic_id, ic_code, ic_address",
        "from dm_icard",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ic_id", property="icId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="ic_code", property="icCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ic_address", property="icAddress", jdbcType=JdbcType.VARCHAR)
    })
    CardEntity selectByPrimaryKey(Integer icId);

    @UpdateProvider(type=CardEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CardEntity record);

    @Update({
        "update dm_icard",
        "set ic_code = #{icCode,jdbcType=VARCHAR},",
          "ic_address = #{icAddress,jdbcType=VARCHAR}",
        "where ic_id = #{icId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CardEntity record);
}