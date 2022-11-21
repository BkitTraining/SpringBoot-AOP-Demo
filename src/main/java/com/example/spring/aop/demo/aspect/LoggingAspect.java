package com.example.spring.aop.demo.aspect;

import com.example.spring.aop.demo.annotation.LogMethod;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Aspect
@Component
@Log4j2
public class LoggingAspect {

  private static final StopWatch stopWatch = new StopWatch();

  @Around("@within(logMethod) || @annotation(logMethod)")
  public Object logMethodExecution(ProceedingJoinPoint pjp, LogMethod logMethod) throws Throwable {
    final MethodSignature signature = (MethodSignature) pjp.getSignature();
    final Method method = signature.getMethod();
    try {
      final String arguments = IntStream.iterate(0, i -> i + 1)
          .limit(Math.min(signature.getParameterNames().length, pjp.getArgs().length))
          .mapToObj(i -> signature.getParameterNames()[i] + "=" + pjp.getArgs()[i])
          .collect(Collectors.joining(","));
      log.info("Start execution of {} with arguments: {}", method, arguments);
      stopWatch.start();
      final Object result = pjp.proceed();
      stopWatch.stop();
      log.info("Finish execution of {} (running {} ns)", method, stopWatch.getTotalTimeNanos());
      return result;
    } catch (Exception ex) {
      log.error("Fail execution of {} (running {} ns)", method, stopWatch.getTotalTimeNanos(), ex);
      throw ex;
    }
  }

  @AfterThrowing(value = "@within(logMethod) || @annotation(logMethod)", throwing = "error")
  public void logAfterThrowing(JoinPoint pjp, LogMethod logMethod, Throwable error) {
    final MethodSignature signature = (MethodSignature) pjp.getSignature();
    final Method method = signature.getMethod();
    final String arguments = IntStream.iterate(0, i -> i + 1)
        .limit(Math.min(signature.getParameterNames().length, pjp.getArgs().length))
        .mapToObj(i -> signature.getParameterNames()[i] + "=" + pjp.getArgs()[i])
        .collect(Collectors.joining(","));
    log.error("handle exception in {} with cause = {}, arguments = {}",
        method,
        error.getCause() != null ? error.getCause() : "NULL",
        arguments);
  }

}
