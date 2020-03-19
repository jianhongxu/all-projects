package com.xjh.pattern.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:13
 * @Description:
 */
public class ProxyFactory implements MethodInterceptor {

    //被代理的对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }



    @Override
    public Object intercept(Object o, Method method, Object[] agrs, MethodProxy methodProxy)
            throws Throwable {

        System.out.println("cglib的动态代理开始..........");
        Object returnVal = method.invoke(target, agrs);

        return returnVal;
    }

    //获取代理对象
    public <T> T getInstance(){
          Enhancer enhancer = new Enhancer();

          //设置父类
          enhancer.setSuperclass(target.getClass());

          //设置回掉函数
          enhancer.setCallback(this);

          return (T)enhancer.create();
    }
}
