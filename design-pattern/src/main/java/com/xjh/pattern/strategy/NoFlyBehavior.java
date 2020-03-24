package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 22:53
 * @Description:
 */
public class NoFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("不会飞翔...");
    }
}
