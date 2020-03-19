package com.xjh.pattern.proxy.jdkproxy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:01
 * @Description:
 */
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("老师正在授课......");
    }
}
