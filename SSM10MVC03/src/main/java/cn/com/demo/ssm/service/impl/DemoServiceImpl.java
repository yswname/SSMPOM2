package cn.com.demo.ssm.service.impl;

import cn.com.demo.ssm.service.IDemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements IDemoService {
    @Override
    public void demo(String name) {
        System.out.println("execute DemoServiceImpl.demo()......." + name);
    }
}
