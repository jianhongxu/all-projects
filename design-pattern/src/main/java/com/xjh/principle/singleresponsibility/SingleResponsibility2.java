package com.xjh.principle.singleresponsibility;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 1:45
 * @Description: 单一职责原则
 *
 * 这种改法 对原类改动较大  而且有很多个类 代码比较多
 * 但是没有违背单一职责设计原则
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
       new VehicleLoad().run("汽车");
       new VehicleAri().run("飞机");
    }
}

class VehicleLoad{
    public void run(String type){
        System.out.println(type+"在公路上行驶;");
    }
}

class VehicleAri{
    public void run(String type){
        System.out.println(type+"在天空飞行;");
    }
}

