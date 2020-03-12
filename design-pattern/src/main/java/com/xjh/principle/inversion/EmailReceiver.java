package com.xjh.principle.inversion;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 15:55
 * @Description:
 */
public class EmailReceiver implements IReceiver {
    @Override
    public String getInfl() {
        return "电子邮件消息";
    }
}
