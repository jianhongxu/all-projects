package com.xjh.pattern.observer;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:25
 * @Description:
 */
public class Baidu implements Observer {


    private float temp;
    private float pre;
    private float hum;

    @Override
    public void update(float temp, float pre, float hum) {
        this.temp = temp;
        this.pre =pre;
        this.hum = hum;
        //更改后显示
        display();
    }

    public void display(){
        System.out.println("百度 温度:" + temp);
        System.out.println("百度 气压:" + pre);
        System.out.println("百度 湿度:" + hum);
    }
}
