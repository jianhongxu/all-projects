package com.xjh.pattern.observer;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:08
 * @Description:
 */
public class Sina implements Observer {

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
        System.out.println("温度:" + temp);
        System.out.println("气压:" + pre);
        System.out.println("湿度:" + hum);
    }
}
