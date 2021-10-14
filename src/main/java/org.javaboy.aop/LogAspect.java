package org.javaboy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
//这是一个切面
@Aspect
public class LogAspect {

    /*
    统一定义切点
     */
//    @Pointcut("@annotation(Action)")
//    public void pointcut(){
//
//    }

//非侵入式定义切点
    @Pointcut("execution(Integer org.javaboy.aop.service.MyCalculatorImpl.*(..))")
    public void pointcut(){

      }

    /**
     * 前置通知
     */
//    @Before("pointcut()")
    public void before (JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法开始执行了...");
    }

    /**
     *
     * @param joinPoint
     */
//    @After("pointcut()")
    public void after (JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println((name + "方法执行了..."));
    }

    /**
     * 返回通知，可以在该方法中获取目标的返回值，如果返回值为void 则收到null
     * @param joinPoint
     * @param r 返回的参数名称，这里方法的参数名一一对应
     */
//    @AfterReturning(value = "pointcut()",returning = "r")
    public void  returning(JoinPoint joinPoint , Integer r){
        String name = joinPoint.getSignature().getName();
        System.out.println((name + "方法返回通知" + r));
    }

    /**
     * 异常通知，当目标方法抛出异常会触发
     * @param joinPoint
     * @param e 异常参数，和方法的参数名一致，注意异常的类型
     */
//    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"name = " +e.getMessage());
    }

//    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //类似于method.invoke方法
//        Object proceed = pjp.proceed(new Object[]{5,5});

        return pjp.proceed();
    }
}
