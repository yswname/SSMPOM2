package cn.com.demoall.ssm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 1、自己读取properties的数据库链接信息
 * 2、创建一个数据源
 * 3、创建SqlSessionFactoryBean（同Spring集成）
 * 4、创建动态接口绑定的bean（@MapperComponentScan）
 */
@Configuration
// spring框架自动加载db.properties
@PropertySource("classpath:db.properties")
@MapperScan("cn.com.demoall.ssm.mapper")
public class MyBatisConfig implements EnvironmentAware {
    private String driverName;
    private String url;
    private String userName;
    private String password;

    @Override
    public void setEnvironment(Environment env) {
        this.url = env.getProperty("jdbc.url");
        this.password = env.getProperty("jdbc.password");
        this.driverName = env.getProperty("jdbc.driverClass");
        this.userName = env.getProperty("jdbc.user");
    }

    @Bean
    @Autowired
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource ds) {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(ds);
        return manager;
    }

    @Bean("dataSource")
    public DataSource createDatasource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setPassword(this.password);
        ds.setUsername(this.userName);
        ds.setUrl(this.url);
        ds.setDriverClassName(this.driverName);
        return ds;
    }

    // 实现Spring同MyBatis的集成
    @Bean("sqlSessionFactoryBean")
    @Autowired
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource ds) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        // 实体的报名（给每个实体起别名）
        factoryBean.setTypeAliasesPackage("cn.com.demoall.ssm.entity");
        return factoryBean;
    }
}
