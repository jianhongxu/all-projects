package com.xjh.pattern.observer;

import java.util.ArrayList;
import java.util.List;


/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:11
 * @Description:
 */
public class WeatherData implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private float temp;
    private float pre;
    private float hum;

    /**
     * 数据改变
     * @param temp
     * @param pre
     * @param hum
     */
    public void setData(float temp, float pre, float hum) {
        this.temp = temp;
        this.pre = pre;
        this.hum = hum;
        //数据改变 通知各个观察者
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        //添加一个观察者
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        //移除一个观察者
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
             observer.update(temp, pre, hum);
        }
    }
}
