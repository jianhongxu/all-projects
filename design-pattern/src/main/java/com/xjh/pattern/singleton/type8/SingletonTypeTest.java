package com.xjh.pattern.singleton.type8;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 18:34
 * @Description: 枚举的方式来实现 推荐
 *
 */
public class SingletonTypeTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.INSTACNE;
        Singleton singleton2 = Singleton.INSTACNE;
        System.out.println(singleton == singleton2);
        System.out.println(singleton.hashCode()+":"+singleton2.hashCode());

        singleton2.sayOk();
    }
}

enum Singleton{
    INSTACNE;
    public void sayOk(){
        System.out.println("ok...");
}
}



