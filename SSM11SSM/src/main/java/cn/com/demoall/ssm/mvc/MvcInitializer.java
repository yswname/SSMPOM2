package cn.com.demoall.ssm.mvc;

import cn.com.demoall.ssm.config.SpringConfig;
import cn.com.demoall.ssm.config.SpringMVCConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // 初始化 root WebApplicationContext
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    // 初始化 servlet WebApplicationContext
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}