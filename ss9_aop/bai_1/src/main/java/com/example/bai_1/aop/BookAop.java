package com.example.bai_1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAop {
    private long requestsToServer = 0;
    @Pointcut("within(com.example.bai_1.aop.*)")
    public void countRequestsToServer() {
    }

    @Before("countRequestsToServer()")
    public void beforeCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.requestsToServer++;
        System.out.println("The request of requests to server: " + this.requestsToServer);
    }

    @After("countRequestsToServer()")
    public void afterCountNumberOfClientsHandler(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
        this.requestsToServer++;
        System.out.println("The request of requests to server: " + this.requestsToServer);
    }
}
