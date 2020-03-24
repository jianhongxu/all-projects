package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 22:53
 * @Description:
 */
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞翔技术一般...");
    }
}
