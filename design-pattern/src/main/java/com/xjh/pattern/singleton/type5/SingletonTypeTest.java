package com.xjh.pattern.singleton.type5;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 饱汉式(线程不安全  同步代码块) 开发中不用这种
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
    public static Singleton getInstance(){
        if(null == instance){
            //存在线程安全问题
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}



