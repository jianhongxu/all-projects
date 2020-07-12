package com.xjh.pattern.adapter.objectadapter;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/12 21:01
 * @Description: 类适配器  实现接口 加 聚合
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int target = voltage220V.output220V() / 44;
        return target;
    }
}
