package cn.com.demoall.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("cn.com.demoall.ssm.service")
@EnableTransactionManagement
@EnableAspectJAutoProxy
// 初始化MyBatis
@Import(value = {MyBatisConfig.class})
public class SpringConfig {

}
