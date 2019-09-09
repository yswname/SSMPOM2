package cn.com.demo;

import cn.com.demo.servlet.HelloServlet;
import cn.com.demo.ssm.mvc.service.IHelloService;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(IHelloService.class)
public class MyWebInitializer implements ServletContainerInitializer {
    @Override// Web容器
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        // 注册  <servlet> <servlet-name><servlet-class>
        ServletRegistration.Dynamic dynamic = ctx.addServlet("HelloServlet", HelloServlet.class);
        // addMapping <servlet-mapping>
        dynamic.addMapping("/helloServlet");

        if (c != null) {
            for (Class serviceClass : c) {
                //System.out.println(service.getClass().getName());
                IHelloService service1 = null;
                try {
                    service1 = (IHelloService) serviceClass.newInstance();
                    service1.test();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
