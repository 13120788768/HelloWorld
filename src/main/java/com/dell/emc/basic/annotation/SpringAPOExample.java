package com.dell.emc.basic.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class SpringAPOExample {
    // 切点
    @Pointcut("@annotation(com.dell.emc.basic.annotation.AnnotationExample)")
    public void aspect() {

    }

    //配置前置通知,使用在方法aspect()上注册的切入点
    //同时接受JoinPoint切入点对象,可以没有该参数
    @Before("aspect()")
    public void Before() {
        System.out.println("Before method");
    }

    // 后置通知
    @After("aspect()")
    public void After(JoinPoint point) {
        System.out.println("after ...." + point.toString());
    }

    // 最终通知 - 设定返回值为String对象
    @AfterReturning(pointcut = "aspect()", returning = "res")
    public void AfterReturning(String res) {
        System.out.println("----AfterReturning方法开始执行:---"+res);
    }

    //异常通知
    @AfterThrowing(pointcut="aspect()",throwing="e")
    public void AfterThrowing(Throwable e) {
        System.out.println("-----AfterThrowing方法开始执行:"+e);
    }

    //@Around注解可以用来在调用一个具体方法前和调用后来完成一些具体的任务。
    // 这里的返回值等于方法的返回值
    @Around("aspect()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----Around方法开始执行:");
        Signature signature = joinPoint.getSignature();
        // 获取注解绑定的方法
        Method method = ((MethodSignature)signature).getMethod();
        AnnotationExample annotation = AnnotationUtils.getAnnotation(method, AnnotationExample.class);

        System.out.println("aop info --->" + annotation.info());

        // 获取入参
        Object[] inputArgs = joinPoint.getArgs();
        // 获取参数名
        String[] argNames = ((MethodSignature) signature).getParameterNames();
        Map<String, Object> paramMap = new HashMap<>();
        for(int i = 0; i < argNames.length; i++) {
            paramMap.put(argNames[i], inputArgs[i]);
        }
        System.out.println("入参" + paramMap.toString());

        // 修改入参
        inputArgs[0] = "spring aop args";
        // 执行方法
        Object result = joinPoint.proceed(inputArgs);
        System.out.println( "反射结果----->"+ result);

        // 返回结果
        return result;
    }

}
