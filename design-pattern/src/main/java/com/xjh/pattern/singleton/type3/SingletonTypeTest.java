package com.xjh.pattern.singleton.type3;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 饱汉式(线程安全 同步方法)
 *
 * 获取实例的效率低 因为每次都有锁
 *
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()== Singleton.getInstance());
    }
}

class Singleton{
    private static Singleton instance;
    private Singleton(){}
    public static  Singleton getInstance(){
        //包含式是没有的时候在new出对象
        if(null == instance){
            instance = new Singleton();
        }
        return instance;
    }
}



