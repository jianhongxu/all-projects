package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 22:59
 * @Description: 野鸭
 */
public class WildDuck extends Duck {

    //构造器 传入FlyBehavor的对象
    public WildDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("这是一只野鸭");
    }
}
