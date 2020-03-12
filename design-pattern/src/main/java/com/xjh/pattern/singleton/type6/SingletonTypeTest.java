package com.xjh.pattern.singleton.type6;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 双端检查 DCL
 *
 * 这种方式比较好
 *
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance()== Singleton.getInstance());
    }
}

class Singleton{

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        //双端dcl
        if(null == instance){
            synchronized (Singleton.class) {
                if(null == instance){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}



