package com.xjh.pattern.observer;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:07
 * @Description:
 */
public interface Observer {

    /**
     * 更新天气的方法
     * @param temp
     * @param pre
     * @param hum
     */
    void update(float temp, float pre, float hum);
}
