package cn.com.demo.ssm.anno.spring.anno.service.impl;

import cn.com.demo.ssm.anno.spring.anno.service.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service("logService")//<bean id="logService"
@Aspect// 切面
public class LogServiceImpl implements ILogService {
    @Override
    @Before("cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.servcieLayer() && cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.allMethod()")
    public void beforeAdvice() {
        System.out.println("...log ... beforeAdvice");
    }

    @Override
    @After("cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.daoLayer() && cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.allMethod()")
    public void afterAdvice() {
        System.out.println("...log ... afterAdvice");
    }

    @Override
    public void afterReturningAdvice() {
        System.out.println("...log ... afterReturningAdvice");
    }


    @Override
    @AfterReturning(value = "cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.servcieLayer() && cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.allMethod() && cn.com.demo.ssm.anno.spring.anno.service.SystemPointcuts.args2(userName,password)", returning = "rtnVal")
    public void afterReturningAdvice(String password, String userName, boolean rtnVal) {
        System.out.println("...log ... afterReturningAdvice");
        System.out.println("     userName:" + userName + ", password:" + password + " ,return:" + rtnVal);
    }

    @Override
    public void returnThrowingAdvice() {
        System.out.println("...log ... returnThrowingAdvice");
    }

    @Override
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object result = null;
        System.out.println("...log ... aroundAdvice ... begin");
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("...log ... aroundAdvice ... end");
        return result;
    }
}
