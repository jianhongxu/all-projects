package com.xjh.pattern.strategy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 22:54
 * @Description: 鸭子类
 */
public abstract class Duck {

    //属性 是策略接口
    FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public Duck() {
    }

    /**
     * 综合描述鸭子的方法
     */
    public abstract void display();

    public  void quack(){
        System.out.println("鸭子嘎嘎叫...");
    }

    public void swim(){
        System.out.println("鸭子会游泳...");
    }

    public void fly(){
        if(null != flyBehavior){
            flyBehavior.fly();
        }
    }


}
