package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class MainAspect {
    private long numberOfRequestToServer = 0;
    @Pointcut("within(com.example.demo.controller.*)")
    public void countNumberOfRequestToServer() {
    }

    @Before("countNumberOfRequestToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.numberOfRequestToServer++;
        System.out.println("The number of requests to server: " + this.numberOfRequestToServer);
    }
}
