package com.xjh.pattern.proxy.cglibproxy;



/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:06
 * @Description:
 */
public class ClientTest {
    /**
     * cglib的动态代理  被代理的对象可以不用实现接口
     * @param args
     */
    public static void main(String[] args) {
        TeacherDao teacherDao = new TeacherDao();
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        TeacherDao teacherDaoProxy = (TeacherDao)proxyFactory.getInstance();

        teacherDaoProxy.teach();


    }

}
