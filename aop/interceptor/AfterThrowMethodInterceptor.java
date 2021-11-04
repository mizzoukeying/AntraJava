package com.example.java20il2021.week3.aop.interceptor;

import com.example.java20il2021.week3.aop.MethodInvocation;

import java.lang.reflect.Method;
import com.example.java20il2021.week3.aop.MethodInvocation;

import java.lang.reflect.Method;

public class AfterThrowMethodInterceptor implements MethodInterceptor{

    private Object aspectObj;
    private Method aspectMethod;

    public AfterThrowMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    //不确定是不是这种写法，看着好像不太对
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{
        Object result=null;
        try{
            result = mi.proceed();


        }catch(Throwable tr){

            aspectMethod.setAccessible(true);
            aspectMethod.invoke(aspectObj);
            return result;

        }
        return result;

    }

}

