package cn.com.demo.ssm.spring.service.impl;

import cn.com.demo.ssm.spring.service.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogServiceImpl implements ILogService {
    @Override

//    public void log(JoinPoint jp) {
//        jp.getArgs();
    public void log() {
        System.out.println("invoke log..................");
    }

    @Override
    public void log2(String password, String userName) {
        System.out.println("log......userName:" + userName + ",password:" + password);
    }

    public Object testArround(ProceedingJoinPoint jpj) {
        Object[] args = jpj.getArgs();
        for (Object o : args) {
            System.out.print(o + ",");
        }
        System.out.println();
        Object result = null;
        System.out.println("begin......................log");
        try {
            result = jpj.proceed();//传递 调用目标方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("end.........................log");
        return result;
    }
}
