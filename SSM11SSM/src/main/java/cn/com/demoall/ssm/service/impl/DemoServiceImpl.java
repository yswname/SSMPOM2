package cn.com.demoall.ssm.service.impl;

import cn.com.demoall.ssm.entity.UserEntity;
import cn.com.demoall.ssm.mapper.UserEntityMapper;
import cn.com.demoall.ssm.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("demoService")
@Transactional
public class DemoServiceImpl implements IDemoService {
    @Autowired
    private UserEntityMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void register(UserEntity user) {
        this.userMapper.insert(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> searchAllUsers() {
        return this.userMapper.findAll();
    }
}
