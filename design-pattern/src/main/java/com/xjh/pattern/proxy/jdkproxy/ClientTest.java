package com.xjh.pattern.proxy.jdkproxy;


/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/18 23:06
 * @Description:
 */
public class ClientTest {
    /**
     * jdk的动态代理  被代理的对象必须实现接口
     * @param args
     */
    public static void main(String[] args) {

        // 保存生成的代理类的字节码文件
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        TeacherDao teacherDao = new TeacherDao();

        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);

        ITeacherDao teacherDaoProxy = (ITeacherDao)proxyFactory.getInstance();

        teacherDaoProxy.teach();
    }

}
