//package com.example.spring.aop.demo.aspect;
//
//import lombok.extern.log4j.Log4j2;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Component
//@Log4j2
//public class LoggingAspectOld {
//
//  @Before("execution(* com.example.spring.aop.demo.service.EmployeeServiceImpl.addEmployee(..))")
//  public void logBefore(JoinPoint joinPoint) {
//    log.info("logBefore running .....");
//    log.info("Enter: {}() with {} = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//  }
//
//  @After("execution(* com.example.spring.aop.demo.service.EmployeeServiceImpl.addEmployee(..))")
//  public void logAfter(JoinPoint joinPoint) {
//    log.info("logAfter running .....");
//    log.info("Enter: {}() with {} = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//  }
//
//  @AfterReturning(pointcut = "execution(* com.example.spring.aop.demo.service.EmployeeServiceImpl.deleteEmployee(..))", returning = "result")
//  public void logAfterReturning(JoinPoint joinPoint, Object result) {
//    log.info("logAfterReturning running .....");
//    log.info("Enter: {}() with {} = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//    log.info("result: {}", result);
//  }
//
//}
