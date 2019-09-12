package cn.com.demo.ssm.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@ComponentScan(basePackages = "cn.com.demo.ssm.web.controller")
@EnableWebMvc// mvc:annotation-driven
// 完成了SpringMVC得所有默认配置
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 禁用后缀访问   /xx.do 等有后缀请求不支持
        configurer.setUseRegisteredSuffixPatternMatch(true);
        // 支持MatrixVariable变量
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        // 支持带分号请求，缺省是不支持的
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Bean("viewResolver")
    public UrlBasedViewResolver createUrlBasedViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();

        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        adapter.getMessageConverters().add(jsonConverter);

        return adapter;
    }
}
