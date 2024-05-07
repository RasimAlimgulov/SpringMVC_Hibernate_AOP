package spring.mvc_hibernate_aop.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    private static final Logger logger = LogManager.getLogger(MyAspect.class);
    @Around("execution(* spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllMethodsInDaoAdvise(ProceedingJoinPoint joinPoint){
        MethodSignature methodSignature=(MethodSignature) joinPoint.getSignature();
       String nameMethod=methodSignature.getMethod().getName();
      //  System.out.println("Start of "+nameMethod);
        Object result;
        logger.info("Started method : "+nameMethod+"\n\n\n");
        try {
            result=joinPoint.proceed();
        } catch (Throwable e) {
            logger.error("Произошла ошибка в DAO методах: ",e);
            throw new RuntimeException(e);
        }
        logger.info("Method finished : "+nameMethod+"\n\n\n");
      //  System.out.println("End of "+nameMethod);
        return result;
    }
}
