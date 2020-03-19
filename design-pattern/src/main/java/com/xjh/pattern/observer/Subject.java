package com.xjh.pattern.observer;



/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:05
 * @Description:
 */
public interface Subject {

    //增加观察
    void registerObserver(Observer o);

    //取消观察
    void removeObserver(Observer o);

    //通知
    void notifyObserver();
}
