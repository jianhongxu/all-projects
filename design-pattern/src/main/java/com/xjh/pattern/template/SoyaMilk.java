package com.xjh.pattern.template;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/4/6 0:25
 * @Description: 豆浆的抽象类 红豆
 */
public  abstract class SoyaMilk {
    /**
     * 制作豆浆
     */
    public void make(){
        select();
        add();
        soak();
        beat();
    }

    /*
     * 1 选材料
     */
    public void select(){
        System.out.println("制作豆浆第一步  选择材料");
    }

    /**
     * 2 添加配料
     */
    public abstract void add();

    public void soak(){
        System.out.println("3 浸泡");
    }
    public void beat(){
        System.out.println("4 豆浆机制作");
    }
}
