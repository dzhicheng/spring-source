package com.dongzhic.aop.aspectj;

import com.dongzhic.annotation.ReturnValue;
import com.dongzhic.annotation.TargetMethod;
import com.dongzhic.annotation.ThrowsAnno;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author dongzhic
 * @Date 7/13/21 7:47 AM
 */
@Component
@Aspect
public class AspectAnnotation {

    /**
     * @Pointcut表示，在包下(com.dongzhic.service)的所有类和方法都会被拦截
     */
    @Pointcut("execution(public * com.dongzhic.service.*.*(..))")
    public void pc1 (){}

    @Pointcut("execution(public * com.dongzhic.service.*.add*(..))")
    public void pc2 (){}

    @Pointcut("execution(public * com.dongzhic.service1.*.*(..))")
    public void pc3 (){}

    /**
     * advice 通知，增强
     * pc1()被拦截的方法都会执行around()方法
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==================AspectAnnotation around前置通知============================");
        // 调用被代理方法
        Object result = joinPoint.proceed();
        System.out.println("==================AspectAnnotation around后置通知============================");

        return result;
    }

    @Before("pc2()")
    public void before () {
        System.out.println("==================只拦截add方法============================");
    }

    @Before("pc3()")
    public void before1 (JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        // 获取被拦截方法的入参
        Object[] args = joinPoint.getArgs();
        System.out.println("==================service1包的拦截============================");

    }

    @Before("pc3()&&args(bankId,id,list)")
    public void before2 (String bankId, int id, List list) {
        System.out.println("==================service1包的拦截============================");
    }

    @Before(value = "@annotation(targetMethod)", argNames = "joinPoint,targetMethod")
    public void xx (JoinPoint joinPoint, TargetMethod targetMethod) {
        System.out.println("==================注解拦截，前置通知============================");
        System.out.println("==================TargetMethod.name = " + targetMethod.name());
    }

    @AfterReturning(value = "@annotation(returnValue)", returning = "retVal")
    public void afterReturning (JoinPoint joinPoint, ReturnValue returnValue, Object retVal) {
        System.out.println("==================AspectAnnotation 后置通知 拿返回值：" + retVal);
    }

    @AfterThrowing(value = "@annotation(throwsAnno)",throwing = "e")
    public void throwMethod (JoinPoint joinPoint, ThrowsAnno throwsAnno, Throwable e) {
        System.out.println("==================AspectAnnotation 异常通知 拿异常：" + e);
    }

























}
