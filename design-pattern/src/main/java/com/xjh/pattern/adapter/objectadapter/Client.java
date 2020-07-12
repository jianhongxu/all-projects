package com.xjh.pattern.adapter.objectadapter;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/12 21:03
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
