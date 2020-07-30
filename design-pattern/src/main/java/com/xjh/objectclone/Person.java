package com.xjh.objectclone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/29 15:47
 * @Description: 拷贝的对象person
 */
public class Person implements Cloneable{
    //年龄
    private int age;
    //姓名
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person person1 = new Person(10,"老王");
        try {
            Person person2 = (Person)person1.clone();

            /**
             * com.xjh.objectclone.Person@3419866c
             * com.xjh.objectclone.Person@63e31ee
             * 两个对象地址不一样  说明克隆成功
             *
             * 问题：
             * age是基本数据类型，拷贝的值没有疑问，
             * 对应name是引用类型， 那这两个person的name的地址是一样吗？ 还是不一样？
             */
            System.out.println(person1);
            System.out.println(person2);


            //下面返回true  name的地址是一样的  所以是引用的同一个对象
            System.out.println(person1.getName() == person2.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
