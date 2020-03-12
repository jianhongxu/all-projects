package com.xjh.principle.singleresponsibility;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 1:41
 * @Description: 单一职责原则
 *
 * 方法级别的单一设计原则  不是类上的单一设计原则
 * 如果一个类中方法比较多 这种方式不好
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle2 vehicle = new Vehicle2();
        vehicle.run("小汽车");
        vehicle.run("摩托车");

        vehicle.runAri("飞机");

        vehicle.runWater("轮船");
    }
}

//交通工具
class Vehicle2{
    public void run(String type){
        System.out.println(type+"在公路上行驶;");
    }

    public void runAri(String type){
        System.out.println(type+"在天空飞行;");
    }

    public void runWater(String type){
        System.out.println(type+"在水里航行;");
    }
}

