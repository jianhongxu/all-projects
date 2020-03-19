package com.xjh.pattern.proxy.staticproxy;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:06
 * @Description:
 */
public class ClientTest {
    /**
     * 静态代理
     * @param args
     */
    public static void main(String[] args) {
        TeacherDao teacher = new TeacherDao();

        TeacherProxy teacherProxy = new TeacherProxy(teacher);

        teacherProxy.teach();
    }

}
