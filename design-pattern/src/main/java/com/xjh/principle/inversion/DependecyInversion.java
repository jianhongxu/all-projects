package com.xjh.principle.inversion;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 15:47
 * @Description: 依赖倒转原则:
 */
public class DependecyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email{
    public String getInfl(){
        return "电子邮件";
    }
}

/**
 * 1 简单
 * 2 如果我们获取的消息时从微信 短信等方式 需要新增类
 * 3 解决思路: 引入一个抽象的接口IReceiver 表示接受类， person与IReceiver发生依赖
 */
class Person{
    public void receive(Email email){
        System.out.println(email.getInfl());
    }
}
