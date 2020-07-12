package com.xjh.pattern.adapter.interfaceadapter;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/12 20:53
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        AbsAdaper absAdaper = new AbsAdaper() {
            @Override
            public void m1() {
                super.m1();
                System.out.println("使用接口抽象模式 重写m1方法");
            }
        };

        //调用m1方法
        absAdaper.m1();
    }
}
