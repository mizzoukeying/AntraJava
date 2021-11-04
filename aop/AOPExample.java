package com.example.java20il2021.week3.aop;

import com.example.java20il2021.week3.aop.advice.*;
import com.example.java20il2021.week3.aop.interceptor.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class AdvisedSupport{

    private Object aspectObj;
    private Map<Method, List<MethodInterceptor>> methodListMap;

    public List<MethodInterceptor> getInteceptors(Method method){

        return methodListMap.get(method);
    }


    //收集 aspect 对所有aspect进行分析，扫描， 添加进methodListMap
    public void scan(Object aspectclass, AdvisedSupport advisedSupport){
        Class<?> aspectObj = aspectclass.getClass();
        //找到PointCut annotation 并通过annocation中class找到对应的originalmethod
        Object originalClass= aspectObj.;
        //找到class里对应的original method
        for(Method aspectMethod: aspectObj.getDeclaredMethods()) {
            for(Annotation ano: aspectMethod.getDeclaredAnnotations()) {

                //根据扫描到的annotation来用不同的MethodInterceptor实现类
                MethodInterceptor methodInterceptor = null;
                if(ano.annotationType() == Before.class) {

                }
//                if(ano.annotationType() == After.class) {
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



            }


        }


@PointCut(value=AOPExample.class)
public class AOPExample {










    public static void main(String[] args) {
        AdvisedSupport advisedSupport=null;


        PointCut annotation= (PointCut)AOPExample.class.getDeclaredAnnotations()[0];
        System.out.println(annotation.value());



        EmployeeService es = (EmployeeService) Proxy.newProxyInstance(
                AOPExample.class.getClassLoader(),
                new Class[]{EmployeeService.class},
                new JdkAOPInvocationHandler(new EmployeeServiceImpl1(), advisedSupport)
        );
        int val = es.get();
        System.out.println(val);
    }
}




interface EmployeeService {
    int get();
    void print();
}

class EmployeeServiceImpl1 implements EmployeeService {
    @Override
    public int get() {
        System.out.println("this is get()");
        return 6;
    }

    @Override
    public void print() {
        System.out.println("print");
    }
}

@PointCut(value=AOPExample.class)
class newAspect{
    @After

    public void after3Fun() {
        System.out.println("this is after3333");
    }
    @Before
    public void before2Fun() {
        System.out.println("this is before2222");
    }

    @Around
    public Object around1Fun(MethodInvocation mi) throws Throwable{
        System.out.println("-- -- --- this is around1111 before -------");
        Object res = mi.proceed();
        System.out.println("-- -- --- this is around1111 after -------");
        return res;
    }

    @Around
    public Object around2Fun(MethodInvocation mi) throws Throwable{
        System.out.println("-- -- --- this is around2222 before -------");
        Object res = mi.proceed();
        System.out.println("-- -- --- this is around2222 after -------");
        return res;
    }
    @AfterReturn
    public void afterReturn1Fun() {
        System.out.println("出现的代码!!!!!!!");
    }

    @AfterThrow
    public void afterThrow1Fun() {
        System.out.println("不可能出现的代码!!!!!!!");
    }

}


//  for(Method aspectMethod: aspectClass.getDeclaredMethods()) {
//          for(Annotation ano: aspectMethod.getDeclaredAnnotations()) {
//
//          //根据扫描到的annotation来用不同的MethodInterceptor实现类
//          MethodInterceptor methodInterceptor = null;
//          if(ano.annotationType() == Before.class) {
//        methodInterceptor = new BeforeMethodInterceptor(aspectObj, aspectMethod);
//        }
//                if(ano.annotationType() == After.class) {
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
        interceptors.add(methodInterceptor);
        }


//class EmployeeAspect {
//    @After
//    @PointCut
//    public void after1Fun() {
//        System.out.println("this is after1111");
//    }
//    @After
//    public void after2Fun() {
//        System.out.println("this is after2222");
//    }
//    @Before
//    public void before1Fun() {
//        System.out.println("this is before1111");
//    }
//    @After
//    public void after3Fun() {
//        System.out.println("this is after3333");
//    }
//    @Before
//    public void before2Fun() {
//        System.out.println("this is before2222");
//    }
//
//    @Around
//    public Object around1Fun(MethodInvocation mi) throws Throwable{
//        System.out.println("-- -- --- this is around1111 before -------");
//        Object res = mi.proceed();
//        System.out.println("-- -- --- this is around1111 after -------");
//        return res;
//    }
//
//    @Around
//    public Object around2Fun(MethodInvocation mi) throws Throwable{
//        System.out.println("-- -- --- this is around2222 before -------");
//        Object res = mi.proceed();
//        System.out.println("-- -- --- this is around2222 after -------");
//        return res;
//    }
//    @AfterReturn
//    public void afterReturn1Fun() {
//        System.out.println("出现的代码!!!!!!!");
//    }
//
//    @AfterThrow
//    public void afterThrow1Fun() {
//        System.out.println("不可能出现的代码!!!!!!!");
//    }
//
//}


