package com.xjh.pattern.strategy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/24 23:06
 * @Description: 测试策略模式
 */
public class Client {

    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();

        BeiJingDuck beiJingDuck = new BeiJingDuck();
        beiJingDuck.fly();

        //动态改变飞的行为
        beiJingDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("北京鸭子的实际飞翔行为");
        beiJingDuck.fly();



        //jdk中的comparator接口  Arrays
        Integer[] data = {12,35,56,89,21,12,457,2231,7};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        //排序
        Arrays.sort(data, comparator);

        //输出
        System.out.println(Arrays.toString(data));

    }
}
