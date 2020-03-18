package com.xjh.pattern.singleton.type1;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 饿汉式 静态常量
 * 可能造成内存浪费， 因为是类变量 在类加载的时候就初始化好对象 所以不存在线程安全问题
 * 不能进行懒加载
 * 对于类的初始化 触发条件有很多
 *
 *
 * 单例模式的使用场景：
 *  需要频繁创建和销毁的对象，创建对象耗时过多或者耗费资源过多  比如经常用到的对象、工具类对象、数据源、 session工厂；
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()==Singleton.getInstance());
    }
}


class Singleton{

    private final static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
