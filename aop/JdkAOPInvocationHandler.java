package com.example.java20il2021.week3.aop;


import com.example.java20il2021.week3.aop.advice.After;
import com.example.java20il2021.week3.aop.advice.Around;
import com.example.java20il2021.week3.aop.advice.Before;
import com.example.java20il2021.week3.aop.advice.AfterReturn;
import com.example.java20il2021.week3.aop.advice.AfterThrow;
import com.example.java20il2021.week3.aop.advice.PointCut;

import com.example.java20il2021.week3.aop.interceptor.AfterMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.AroundMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.BeforeMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.MethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.AfterReturnMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.AfterThrowMethodInterceptor;
import com.example.java20il2021.week3.aop.interceptor.PointCutMethodInterceptor;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JdkAOPInvocationHandler implements InvocationHandler {

    private Object originObj;
    private AdvisedSupport advisedSupport;

    public JdkAOPInvocationHandler(Object originObj, AdvisedSupport advisedSupport) {
        this.originObj = originObj;
        this.advisedSupport = advisedSupport;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //通过反射拿到aspectObj的class info
//        Class<?> aspectClass = aspectObj.getClass();
//        List<MethodInterceptor> interceptors = new ArrayList<>();
//        for(Method aspectMethod: aspectClass.getDeclaredMethods()) {
//            for(Annotation ano: aspectMethod.getDeclaredAnnotations()) {
//
//
//                //根据扫描到的annotation来用不同的MethodInterceptor实现类
//                MethodInterceptor methodInterceptor = null;
//                if(ano.annotationType() == Before.class) {
//                    methodInterceptor = new BeforeMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == After.class) {
//                    methodInterceptor = new AfterMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == Around.class) {
//                    methodInterceptor = new AroundMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == AfterReturn.class) {
//                    methodInterceptor = new AfterReturnMethodInterceptor(aspectObj, aspectMethod);
//                } else if(ano.annotationType() == AfterThrow.class) {
//                    methodInterceptor = new AfterThrowMethodInterceptor(aspectObj, aspectMethod);
//                }  else if(ano.annotationType() == PointCut.class) {
//                    methodInterceptor = new PointCutMethodInterceptor(aspectObj, aspectMethod);
//                }
//                interceptors.add(methodInterceptor);
//            }
//        }
        MethodInvocation mi = new ProxyMethodInvocation(advisedSupport.getInteceptors(method), originObj, method, args);
        return mi.proceed();
    }
}
