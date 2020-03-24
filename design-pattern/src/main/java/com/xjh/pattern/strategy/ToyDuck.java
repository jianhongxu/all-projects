package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 23:02
 * @Description:玩具鸭子
 */
public class ToyDuck extends Duck {

    public ToyDuck() {
        //玩具鸭子不能飞
        flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("玩具鸭子");
    }
}
