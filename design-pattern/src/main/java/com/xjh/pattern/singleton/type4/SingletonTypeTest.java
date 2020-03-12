package com.xjh.pattern.singleton.type4;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 饱汉式(线程不安全)
 * 优缺点和静态属性的方式一样
 * 起到懒加载的效果
 * 存在线程不安全问题： if多线程进入
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
    public static synchronized Singleton getInstance(){
        //包含式是没有的时候在new出对象
        if(null == instance){
            instance = new Singleton();
        }
        return instance;
    }
}



