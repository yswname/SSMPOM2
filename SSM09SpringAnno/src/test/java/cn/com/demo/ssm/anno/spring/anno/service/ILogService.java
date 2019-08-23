package cn.com.demo.ssm.anno.spring.anno.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ILogService {
    public void beforeAdvice();

    public void afterAdvice();

    public void afterReturningAdvice();

    public void afterReturningAdvice(String password, String userName, boolean rtnVal);

    public void returnThrowingAdvice();

    public Object aroundAdvice(ProceedingJoinPoint pjp);
}
