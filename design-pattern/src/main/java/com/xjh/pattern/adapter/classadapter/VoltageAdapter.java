package com.xjh.pattern.adapter.classadapter;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/12 21:01
 * @Description: 类适配器  继承加实现
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V{

    @Override
    public int output5V() {
        int target = this.output220V() / 44;
        return target;
    }
}
