package cn.com.demo.ssm.spring.service.impl;

import cn.com.demo.ssm.spring.service.ILogService;

public class LogServiceImpl implements ILogService {
    @Override
    public void log() {
        System.out.println("invoke log..................");
    }
}
