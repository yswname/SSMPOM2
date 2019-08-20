package cn.com.demo.ssm.spring.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ILogService {
    public void log();

    public void log2(String password, String userName);

    public Object testArround(ProceedingJoinPoint jpj);
}
