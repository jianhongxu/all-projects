package com.xjh.fx;

import java.lang.reflect.ParameterizedType;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/31 10:36
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

    }

    private void test(){
        //经典代码
        //Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
