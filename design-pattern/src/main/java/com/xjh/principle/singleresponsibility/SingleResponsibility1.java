package com.xjh.principle.singleresponsibility;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 1:41
 * @Description: 单一职责原则
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("小汽车");
        vehicle.run("摩托车");
        //飞机不能在公路上跑 违背了单一职责设计原则
        vehicle.run("飞机");
    }
}

//交通工具
class Vehicle{
    public void run(String type){
        System.out.println(type+"在公路上行驶;");
    }
}

