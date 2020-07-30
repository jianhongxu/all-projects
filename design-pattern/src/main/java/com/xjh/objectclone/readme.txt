java中的深拷贝和浅拷贝
https://www.cnblogs.com/xuxinstyle/p/9334258.html

object中的 protected native Object clone()  默认是一个浅拷贝的方法

深拷贝：拷贝对象中的引用类型 也会生成一份不同的对象
欠拷贝：拷贝对象中的引用类型是同一对象


 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆;