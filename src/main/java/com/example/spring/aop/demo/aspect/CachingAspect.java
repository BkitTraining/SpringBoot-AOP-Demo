package com.example.spring.aop.demo.aspect;

import com.example.spring.aop.demo.annotation.CachingMethod;
import com.example.spring.aop.demo.annotation.LogMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Aspect
@Component
@Log4j2
public class CachingAspect {

  @AfterReturning(pointcut = "@within(cachingMethod) || @annotation(cachingMethod)", returning = "result")
  public void logMethodExecution(JoinPoint pjp, CachingMethod cachingMethod, Object result) throws Throwable {
    final MethodSignature signature = (MethodSignature) pjp.getSignature();
    final Method method = signature.getMethod();
    String shortMethod = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
    log.info("Update Caching for {} - return value: {}", shortMethod, result);
  }

}
