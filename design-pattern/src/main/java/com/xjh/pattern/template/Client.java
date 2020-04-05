package com.xjh.pattern.template;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/4/6 0:33
 * @Description: 模板模式的测试客户端
 */
public class Client {

    public static void main(String[] args) {
        //制作黑豆豆浆
        SoyaMilk soyaMilk = new BlackBeanSoyaMilk();
        soyaMilk.make();
        System.out.println("=================");
        //制作红豆豆浆
        soyaMilk = new RedBeanSoyaMilk();
        soyaMilk.make();
    }
}
