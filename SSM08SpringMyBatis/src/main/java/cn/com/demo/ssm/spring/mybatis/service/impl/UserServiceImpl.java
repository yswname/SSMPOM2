package cn.com.demo.ssm.spring.mybatis.service.impl;

import cn.com.demo.ssm.spring.mybatis.dao.RlUrMapEntityMapper;
import cn.com.demo.ssm.spring.mybatis.dao.RoleEntityMapper;
import cn.com.demo.ssm.spring.mybatis.dao.UserEntityMapper;
import cn.com.demo.ssm.spring.mybatis.entity.RlUrMapEntity;
import cn.com.demo.ssm.spring.mybatis.entity.RoleEntity;
import cn.com.demo.ssm.spring.mybatis.entity.UserEntity;
import cn.com.demo.ssm.spring.mybatis.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {
    private UserEntityMapper userMapper;
    private RoleEntityMapper roleMapper;
    private RlUrMapEntityMapper rlUrMapper;

    @Override
    public void saveUser(UserEntity userEntity) {
        if (userEntity != null) {
            // 保存用户
            userMapper.insert(userEntity);
            // 判断用户中是否有关联的角色？
            List<RoleEntity> roleList = userEntity.getRoleList();
            //    如果有， 判断该角色是否存在
            if (roleList != null && roleList.size() > 0) {
                for (RoleEntity role : roleList) {
                    //       如果存在， 持久化当前角色同用户的关系
                    //       如果不存在， 持久化角色 和  角色同用户的关系
                    RoleEntity dbRole = this.roleMapper.findByRlName(role.getRlName());
                    if (dbRole == null) {
                        // 不存在
                        dbRole = role;
                        this.roleMapper.insert(dbRole);
                    }
                    // 持久化关系
                    RlUrMapEntity rlUr = new RlUrMapEntity();
                    rlUr.setMpRlId(dbRole.getRlId());
                    rlUr.setMpUrId(userEntity.getUrId());
                }
            }
            //    如果没有，不用做其它事情了
        }
    }

    public void setUserMapper(UserEntityMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void setRoleMapper(RoleEntityMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public void setRlUrMapper(RlUrMapEntityMapper rlUrMapper) {
        this.rlUrMapper = rlUrMapper;
    }
}
