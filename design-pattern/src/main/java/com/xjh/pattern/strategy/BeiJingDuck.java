package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 23:01
 * @Description:北京鸭子
 */
public class BeiJingDuck extends Duck {

    public BeiJingDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭子");
    }
}
