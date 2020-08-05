package com.xjh.fx;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/8/3 16:01
 * @Description: 经典代码
 */
public class Base<T> {

    private Class<T> entityClass;

    //代码块,也可将其放置到构造子中
    {
        //A.1
        // entityClass =(Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        //A.1上面那句代码 可以写成下面的代码
        try {
            //获取实际运行的类的 Class
            Class<?> clazz = getClass();
            //获取实际运行的类的直接超类的泛型类型
            Type type = clazz.getGenericSuperclass();
            //如果该泛型类型是参数化类型
            if(type instanceof ParameterizedType){
                //获取泛型类型的实际类型参数集
                Type[] parameterizedType = ((ParameterizedType)type).getActualTypeArguments();
                //取出第一个(下标为0)参数的值
                entityClass = (Class<T>) parameterizedType[0];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //泛型的实际类型参数的类全名
    public String getEntityName(){
        return entityClass.getName();
    }

    //泛型的实际类型参数的类名
    public String getEntitySimpleName(){
        return entityClass.getSimpleName();
    }

    //泛型的实际类型参数的Class
    public Class<T> getEntityClass() {
        return entityClass;
    }



    public static void main(String[] args) {
        Base<String> base = new Base<String>();
        //打印输出 null
        System.out.println(base.getEntityClass());
        //抛出 NullPointerException 异常
        //System.out.println(base.getEntityName());
        //抛出 NullPointerException 异常
        //System.out.println(base.getEntitySimpleName());


        SanMao sanMao = new SanMao();
        /**
         * class com.xjh.fx.Child   1
         * com.xjh.fx.Child         2
         * Child                    3
         */
        System.out.println(sanMao.getEntityClass());
        System.out.println(sanMao.getEntityName());
        System.out.println(sanMao.getEntitySimpleName());
    }
}
