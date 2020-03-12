package com.xjh.pattern.singleton.type7;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 静态内部类的方式
 * 懒加载和线程安全都保证
 *
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()== Singleton.getInstance());
    }
}

class Singleton{

    private Singleton(){}

    //静态内部类在外部类加载的时候不会加安装实例化 再调用getInstance()才会加载类实例化
    private static class SingletonInstance{
        private final static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.instance;
    }

}



