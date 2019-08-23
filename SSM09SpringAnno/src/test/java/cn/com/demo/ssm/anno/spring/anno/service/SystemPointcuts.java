package cn.com.demo.ssm.anno.spring.anno.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcuts {
    @Pointcut("within(cn.com.demo.ssm.anno.spring.anno.dao..*)")// dao类
    public void daoLayer() {
    }

    @Pointcut("within(cn.com.demo.ssm.anno.spring.anno.service..*)")//service
    public void servcieLayer() {
    }

    @Pointcut("within(cn.com.demo.ssm.anno.spring.anno.web..*)")//web controller类
    public void webLayer() {
    }

    @Pointcut("execution(* *(..))")
    public void allMethod() {
    }

    @Pointcut("args(p1,p2)")
    public void args2(String p1, String p2) {
    }
}
