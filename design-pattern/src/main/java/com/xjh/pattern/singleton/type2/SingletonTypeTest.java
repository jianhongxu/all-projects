package com.xjh.pattern.singleton.type2;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 饿汉式 静态代码块
 * 优缺点和静态属性的方式一样
 *
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()==Singleton.getInstance());
    }
}

class Singleton{

    private static Singleton instance;

    static {
        //静态代码块中创建对象
        instance = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}



