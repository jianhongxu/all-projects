package com.xjh.objectclone;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/7/29 16:02
 * @Description:
 */
public class Test {

    static class Body implements Cloneable{
        public Head head;

        public Body() {}

        public Body(Head head) {this.head = head;}


        public static void main(String[] args) throws Exception {

            Body body = new Body(new Head());

            Body body1 = (Body) body.clone();

            //false 拷贝出来的对象  内容一样 地址不一样的对象
            System.out.println("body == body1 : " + (body == body1) );

            //false 深拷贝出来的对象
            System.out.println("body.head == body1.head : " +  (body.head == body1.head));

        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            //为了实现深拷贝  需要将head的引用也拷贝出来
            Body newBody =  (Body) super.clone();
            newBody.head = (Head) head.clone();
            return newBody;

            //? 问题
            /**
             * 那么，按照上面的结论， Body类组合了Head类， 而Head类组合了Face类，要想深拷贝Body类，
             * 必须在Body类的clone方法中将Head类也要拷贝一份，但是在拷贝Head类时，默认执行的是浅拷贝，
             * 也就是说Head中组合的Face对象并不会被拷贝。
             */
        }
    }



    static class Head implements Cloneable{
        public  Face face;

        public Head() {}
        public Head(Face face){this.face = face;}
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    static class Face{}


    public static void main(String[] args) throws Exception{
        Body body = new Body(new Head(new Face()));

        Body body1 = (Body) body.clone();

        //false
        System.out.println("body == body1 : " + (body == body1) );

        //false
        System.out.println("body.head == body1.head : " +  (body.head == body1.head));

        //true 这个还是同一个对象  说明不是深拷贝
        System.out.println("body.head.face == body1.head.face : " +  (body.head.face == body1.head.face));

    }
}


