package com.example.java20il2021.week3.aop.interceptor;


import com.example.java20il2021.week3.aop.MethodInvocation;

import java.lang.reflect.Method;

public class AfterReturnMethodInterceptor implements MethodInterceptor{

    private Object aspectObj;
    private Method aspectMethod;

    public AfterReturnMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{
        Object result=null;
        try{
              result = mi.proceed();

//              return result;
        }catch(Throwable tr){
            //当且仅当tr被throw后才会继续执行
            return result;

        }

        aspectMethod.setAccessible(true);
        aspectMethod.invoke(aspectObj);
        return result;
    }

}

