package spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Around("execution(* spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllMethodsInDaoAdvise(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
       String nameMethod=methodSignature.getMethod().getName();
        System.out.println("Start of "+nameMethod);
        Object result;
        try {
            result=joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of "+nameMethod);
        return result;
    }
}
