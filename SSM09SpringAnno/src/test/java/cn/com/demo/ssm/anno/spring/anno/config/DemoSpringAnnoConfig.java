package cn.com.demo.ssm.anno.spring.anno.config;

import cn.com.demo.ssm.anno.spring.anno.dao.IDemoDAO;
import cn.com.demo.ssm.anno.spring.anno.dao.impl.DemoDAOImpl;
import org.springframework.context.annotation.*;

@Configuration// 当前是个配置类
@ComponentScan(basePackages = {"cn.com.demo.ssm.anno.spring.anno.service", "cn.com.demo.ssm.anno.spring.anno.dao"})
@PropertySource(value = "classpath:/config.properties")// 告知ioc容器初始化的时候，加载属性文件
// 中ioc容器初始化的时候，扫哪些类
public class DemoSpringAnnoConfig {
    @Bean
    @Scope(value = "singleton")
    public IDemoDAO createDemoDAO() {
        return new DemoDAOImpl();
    }

    @Bean
    @Scope(value = "singleton")
    @Primary// 多个同类的对，无从选择，选primary
    public IDemoDAO createDemoDAO2() {
        return new DemoDAOImpl();
    }
}
