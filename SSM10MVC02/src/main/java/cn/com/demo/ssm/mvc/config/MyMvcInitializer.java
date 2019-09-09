package cn.com.demo.ssm.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyMvcInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // <servlet> ....
        //        <servlet-name>app</servlet-name>
        //        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("SpringMVC", DispatcherServlet.class);
        //        <load-on-startup>1</load-on-startup>
        dynamic.setLoadOnStartup(1);
        //         <init-param>
        //            <param-name>contextConfigLocation</param-name>
        //            <param-value></param-value>
        //        </init-param>
        dynamic.setInitParameter("contextConfigLocation", "/WEB-INF/classes/SpringMVC-servlet.xml");


        // <servlet-mapping>...
        dynamic.addMapping("/");
    }
}
