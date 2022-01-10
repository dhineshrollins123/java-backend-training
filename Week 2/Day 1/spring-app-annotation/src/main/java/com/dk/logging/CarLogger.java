package com.dk.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class CarLogger {
    @Before("execution(* com.dk.car.*.*(..))")
    public void logBeforeAnyMethodExecutionCarPackage(JoinPoint jp){
        System.out.println("Before Execution Iam getting Printed");
        System.out.println("Executing Method : "+jp.getSignature());
        System.out.println("After this line You will see Method Output");
        System.out.println("-----------------");
    }
}
