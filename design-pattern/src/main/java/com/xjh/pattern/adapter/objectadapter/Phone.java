package com.xjh.pattern.adapter.objectadapter;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/12 21:02
 * @Description:
 */
public class Phone {

    /**
     * 手机用5v电压充电
     * @param iVoltage5V
     */
    public void charging(IVoltage5V iVoltage5V){
        if(iVoltage5V.output5V() == 5){
            System.out.println("对象适配器模式 电压为5v 开始充电");
        }
    }
}
