//package com.example.spring.aop.demo.aspect;
//
//import lombok.extern.log4j.Log4j2;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Component
//@Log4j2
//public class LoggingAspect {
//
//  /**
//   * Run before the method execution.
//   *
//   * @param joinPoint
//   */
//  @Before("execution(* net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService.addEmployee(..))")
//  public void logBefore(JoinPoint joinPoint) {
//    log.debug("logBefore running .....");
//    log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//
//  }
//
//  /**
//   * Run after the method returned a result.
//   *
//   * @param joinPoint
//   */
//  @After("execution(* net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService.addEmployee(..))")
//  public void logAfter(JoinPoint joinPoint) {
//    log.debug("logAfter running .....");
//    log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//  }
//
//  /**
//   * Run after the method returned a result, intercept the returned result as well.
//   *
//   * @param joinPoint
//   * @param result
//   */
//  @AfterReturning(pointcut = "execution(* net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService.deleteEmployee(..))", returning = "result")
//  public void logAfterReturning(JoinPoint joinPoint, Object result) {
//    log.debug("logAfterReturning running .....");
//    log.debug("Enter: {}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//
//  }
//
//  /**
//   * Run around the method execution.
//   *
//   * @param joinPoint
//   * @return
//   * @throws Throwable
//   */
//  @Around("execution(* net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService.getEmployeeById(..))")
//  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//    log.debug("logAround running .....");
//    if (log.isDebugEnabled()) {
//      log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//          joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//    }
//    try {
//      Object result = joinPoint.proceed();
//      if (log.isDebugEnabled()) {
//        log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//            joinPoint.getSignature().getName(), result);
//      }
//      return result;
//    } catch (IllegalArgumentException e) {
//      log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//          joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//      throw e;
//    }
//
//  }
//
//  /**
//   * Advice that logs methods throwing exceptions.
//   *
//   * @param joinPoint join point for advice
//   * @param e         exception
//   */
//
//  @AfterThrowing(pointcut = "execution(* net.guides.springboot2.springboot2jpacrudexample.service.EmployeeService.updateEmployee(..))", throwing = "error")
//  public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
//    log.debug("logAfterThrowing running .....");
//    log.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
//        joinPoint.getSignature().getName(), error.getCause() != null ? error.getCause() : "NULL");
//  }
//}
