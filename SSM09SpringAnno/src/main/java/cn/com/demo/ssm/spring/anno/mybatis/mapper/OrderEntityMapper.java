package cn.com.demo.ssm.spring.anno.mybatis.mapper;

import cn.com.demo.ssm.spring.anno.mybatis.entity.OrderEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface OrderEntityMapper {
    @Delete({
        "delete from dm_order",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer odId);

    @Insert({
        "insert into dm_order (od_id, od_ur_id, ",
        "od_name)",
        "values (#{odId,jdbcType=INTEGER}, #{odUrId,jdbcType=INTEGER}, ",
        "#{odName,jdbcType=VARCHAR})"
    })
    int insert(OrderEntity record);

    @InsertProvider(type=OrderEntitySqlProvider.class, method="insertSelective")
    int insertSelective(OrderEntity record);

    @Select({
        "select",
        "od_id, od_ur_id, od_name",
        "from dm_order",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="od_id", property="odId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="od_ur_id", property="odUrId", jdbcType=JdbcType.INTEGER),
        @Result(column="od_name", property="odName", jdbcType=JdbcType.VARCHAR)
    })
    OrderEntity selectByPrimaryKey(Integer odId);

    @UpdateProvider(type=OrderEntitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderEntity record);

    @Update({
        "update dm_order",
        "set od_ur_id = #{odUrId,jdbcType=INTEGER},",
          "od_name = #{odName,jdbcType=VARCHAR}",
        "where od_id = #{odId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderEntity record);
}