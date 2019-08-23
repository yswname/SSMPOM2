package cn.com.demo.ssm.anno.spring.anno.service.impl;

import cn.com.demo.ssm.anno.spring.anno.dao.IDemoDAO;
import cn.com.demo.ssm.anno.spring.anno.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("demoServiceComp")// 组件
@Service("demoService")
public class DemoServiceImpl implements IDemoService {
    @Autowired // byType->byName
    //@Qualifier("demoDAO1")// byName（指定name）
    //@Resource // byName->byType
    private IDemoDAO demoDAO;

    @Override
    public boolean business(String userName, String password) {
        System.out.println("execute business(" + userName + "," + password + ")");
        return password != null;
    }

    @Override
    public void business() {
        System.out.println("execute DemoServiceImpl.business()");
        this.demoDAO.save();
    }

    // 对象创建好，依赖装配好，再执行
    @PostConstruct
    public void init() {

    }

    // 容器移除前
    @PreDestroy
    public void toDestory() {

    }
}
