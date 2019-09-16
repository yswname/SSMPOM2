package cn.com.demo.ssm.spring.anno.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
//@MapperScan("mapper的包")
public class MyBatisConfig implements EnvironmentAware {
    //@Value("${jdbc.url}")
    private String url;
    //@Value("${jdbc.driverClass}")
    private String driverName;
    //@Value("${jdbc.password}")
    private String password;
    //@Value("${jdbc.user}")
    private String userName;

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
        this.url = env.getProperty("jdbc.url");
        this.password = env.getProperty("jdbc.password");
        this.driverName = env.getProperty("jdbc.driverClass");
        this.userName = env.getProperty("jdbc.user");
    }

    @Bean
    public DataSource createDataSource() {
        System.out.println("************" + this.url);
        DruidDataSource ds = new DruidDataSource();
        ds.setPassword(this.password);
        ds.setUsername(this.userName);
        ds.setUrl(this.url);
        ds.setDriverClassName(this.driverName);
        return ds;
    }

    @Bean("sqlSessionFactoryBean")
    @Autowired
    public SqlSessionFactoryBean createSqlSessionFactoryBean(DataSource ds) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setTypeAliasesPackage("cn.com.demo.ssm.spring.anno.mybatis.entity");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer createMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
        mapperScanner.setBasePackage("cn.com.demo.ssm.spring.anno.mybatis.mapper");
        mapperScanner.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return mapperScanner;
    }
}
