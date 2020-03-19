package com.xjh.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:13
 * @Description:
 */
public class ProxyFactory {

    //被代理的对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     *
     * @param <T>  代表是泛型T这种类型
     * @return T 返回的数据类型是T这种类型
     */
    public <T> T getInstance(){

      return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

              System.out.println("JDK动态代理..");
              Object retrunValue = method.invoke(target,args);
              return retrunValue;
          }
      });
    }

}
