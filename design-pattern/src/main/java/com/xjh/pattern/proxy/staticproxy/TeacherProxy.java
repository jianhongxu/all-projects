package com.xjh.pattern.proxy.staticproxy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:02
 * @Description:
 */
public class TeacherProxy implements ITeacherDao{

    private ITeacherDao target;

    public TeacherProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理...");
        target.teach();
        System.out.println("代理结束...");

    }


}
