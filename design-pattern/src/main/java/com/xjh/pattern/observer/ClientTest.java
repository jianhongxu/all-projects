package com.xjh.pattern.observer;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/19 23:17
 * @Description:
 * 新增一个观察者的时候 只需要新建一个观察者  然后client里注册就可以了 不用修改Subject
 *
 *
 * Jdk中有个Observer类
 */
public class ClientTest {

    public static void main(String[] args) {
        //subject
        WeatherData weatherData = new WeatherData();

        //observeren
        Sina sina = new Sina();

        Baidu baidu = new Baidu();
        //注册观察者
        weatherData.registerObserver(sina);
        weatherData.registerObserver(baidu);

        weatherData.setData(40,20,30);

        weatherData.removeObserver(baidu);
        System.out.println("=============移除一个观察者========================");

        weatherData.setData(400,200,300);

    }



    public  void testJdk(){
        /**
         * java.util.Observable  对应subject  但是它是一个类 已经实现了核心方法
         * java.util.Observer    对应observer
         *
         */

    }
}
