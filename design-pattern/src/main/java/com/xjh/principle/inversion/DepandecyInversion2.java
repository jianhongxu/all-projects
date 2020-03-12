package com.xjh.principle.inversion;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 15:56
 * @Description:
 */
public class DepandecyInversion2 {

    public static void main(String[] args) {
        //客户端代码不会发送改变 便于扩展
        Person person = new Person();
        person.receive(new Email());
    }


    class Person2{
        public void receive(IReceiver receiver){
            System.out.println(receiver.getInfl());
        }
    }
}
