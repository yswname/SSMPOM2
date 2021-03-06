package cn.com.demo.ssm.util.config;

import cn.com.demo.ssm.interceptor.DemoInterceptor;
import cn.com.demo.ssm.interceptor.DemoInterceptor2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.util.UrlPathHelper;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "cn.com.demo.ssm.web.controller")
@EnableWebMvc// mvc:annotation-driven
// 完成了SpringMVC得所有默认配置
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        DemoInterceptor demoInter = new DemoInterceptor();
        DemoInterceptor2 demoInter2 = new DemoInterceptor2();


        InterceptorRegistration registration2 = registry.addInterceptor(demoInter2);
        InterceptorRegistration registration = registry.addInterceptor(demoInter);

        registration.addPathPatterns("/demo/demo");
        registration2.addPathPatterns("/demo/demo");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 设置不需要经过SpringMVC框架过滤的资源，比如js css 和 images等
        registry.addResourceHandler("/static/**").addResourceLocations(
                "/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

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

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //super.extendMessageConverters(converters);
        // 解决@ResponseBody乱码问题   response.setContentType("text/html;charset=utf-8")
        StringHttpMessageConverter httpConverter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        httpConverter.setSupportedMediaTypes(Arrays.asList(
                MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON,
                MediaType.TEXT_HTML));
        converters.add(0, httpConverter);// 需要添加到第一个，避免使用前面的msgConverter

        // 响应json
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        converters.add(jsonConverter);
    }

    @Bean(name = "multipartResolver")// beanName固定
    // 名称固定
    public CommonsMultipartResolver commonsMultipartResolver() {
        CommonsMultipartResolver multiResolver = new CommonsMultipartResolver();
        multiResolver.setMaxUploadSize(10 * 1024 * 1024);
        multiResolver.setDefaultEncoding("UTF-8");
        return multiResolver;
    }

//    @Bean
//    public RequestMappingHandlerAdapter createRequestMappingHandlerAdapter() {
//        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
//
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        adapter.getMessageConverters().add(jsonConverter);
//
//        return adapter;
//    }
}
