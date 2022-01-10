package com.dk.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class CarLogger {
    @Pointcut("execution(public * com.dk.car.Car.speedUp(..))")
    public void pointCutAfterExecution() { }
    @Before("execution(* com.dk.car.*.*(..))")
    public void logBeforeAnyMethodExecutionCarPackage(JoinPoint jp) {
        System.out.println("Before Execution Iam getting Printed");
        System.out.println("Executing Method : " + jp.getSignature());
        System.out.println("After this line You will see Method Output");
        System.out.println("-----------------");
    }
@After("pointCutAfterExecution()")
   public void logAfterAllMethods(JoinPoint jp){
       System.out.println("After Execution Iam Getting Printed...");
   }
}