package com.cundy.work.aop;

import com.cundy.work.holder.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class DataSourceAop {
    @Pointcut("!@annotation(com.cundy.work.annotation.Master) " +
            "&& (execution(* com.cundy.work.service..*.select*(..)) " +
            "|| execution(* com.cundy.work.service..*.get*(..)))")
    public void readPointcut() {
    }

    @Pointcut("@annotation(com.cundy.work.annotation.Master) " +
            "|| execution(* com.cundy.work.service..*.insert*(..)) " +
            "|| execution(* com.cundy.work.service..*.add*(..)) " +
            "|| execution(* com.cundy.work.service..*.update*(..)) " +
            "|| execution(* com.cundy.work.service..*.edit*(..)) " +
            "|| execution(* com.cundy.work.service..*.delete*(..)) " +
            "|| execution(* com.cundy.work.service..*.remove*(..))")
    public void writePointcut() {
    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }
}