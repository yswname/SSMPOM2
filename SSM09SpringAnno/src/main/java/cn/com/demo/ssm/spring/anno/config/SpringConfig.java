package cn.com.demo.ssm.spring.anno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration

@ComponentScans(value = {@ComponentScan(basePackages = "cn.com.demo.ssm.spring.anno.service"),
        @ComponentScan(basePackageClasses = {MyBatisConfig.class})})
@PropertySource(value = "classpath:/db.properties")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    @Autowired
    DataSourceTransactionManager createDataSourceTransactionManager(DataSource ds) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(ds);
        return manager;
    }

}
