package cn.com.demoall.ssm.mapper;

import cn.com.demoall.ssm.entity.RlUrMapEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface RlUrMapEntityMapper {
    @Delete({
        "delete from dm_rl_ur_map",
        "where mp_ur_id = #{mpUrId,jdbcType=INTEGER}",
          "and mp_rl_id = #{mpRlId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("mpUrId") Integer mpUrId, @Param("mpRlId") Integer mpRlId);

    @Insert({
        "insert into dm_rl_ur_map (mp_ur_id, mp_rl_id)",
        "values (#{mpUrId,jdbcType=INTEGER}, #{mpRlId,jdbcType=INTEGER})"
    })
    int insert(RlUrMapEntity record);

    @InsertProvider(type=RlUrMapEntitySqlProvider.class, method="insertSelective")
    int insertSelective(RlUrMapEntity record);
}