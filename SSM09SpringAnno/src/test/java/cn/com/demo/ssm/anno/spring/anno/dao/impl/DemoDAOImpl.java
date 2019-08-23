package cn.com.demo.ssm.anno.spring.anno.dao.impl;

import cn.com.demo.ssm.anno.spring.anno.dao.IDemoDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("demoDAO1")
public class DemoDAOImpl implements IDemoDAO {
    @Value("${jdbc.driverClass}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;

    @Override
    public void save() {
        System.out.println("execute DemoDAOImpl.save()......" + this.driverClassName + "," + this.url);
    }

}
