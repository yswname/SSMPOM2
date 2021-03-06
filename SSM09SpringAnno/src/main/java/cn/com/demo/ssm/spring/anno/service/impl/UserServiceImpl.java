package cn.com.demo.ssm.spring.anno.service.impl;

import cn.com.demo.ssm.spring.anno.mybatis.entity.RlUrMapEntity;
import cn.com.demo.ssm.spring.anno.mybatis.entity.RoleEntity;
import cn.com.demo.ssm.spring.anno.mybatis.entity.UserEntity;
import cn.com.demo.ssm.spring.anno.mybatis.mapper.RlUrMapEntityMapper;
import cn.com.demo.ssm.spring.anno.mybatis.mapper.RoleEntityMapper;
import cn.com.demo.ssm.spring.anno.mybatis.mapper.UserEntityMapper;
import cn.com.demo.ssm.spring.anno.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserEntityMapper userMapper;
    @Autowired
    private RoleEntityMapper roleMapper;
    @Autowired
    private RlUrMapEntityMapper rlUrMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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

                    this.rlUrMapper.insert(rlUr);
                }
            }
            //    如果没有，不用做其它事情了
            String str = null;
            //str.toString();
        }
    }
}