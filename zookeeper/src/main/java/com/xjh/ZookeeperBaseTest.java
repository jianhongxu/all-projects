package com.xjh;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/10 18:42
 * @Description:
 */
public class ZookeeperBaseTest {

    //zookeeper集群连接字符串(防止有服务器挂，所以配置的时候 最好配置多个)
    private String connectString = "192.168.1.5:2181,192.168.1.5:2182,192.168.1.5:2183";

    //链接超时时间 超过多少时间未成功连接就报错   2秒
    private Integer sessionTimeout = 2000;

    private ZooKeeper zooKeeper;

    @Before
    public void initConnect(){
        try {
             zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {

                    System.out.println("监听到的事件是：。。。。。。"+watchedEvent);

                   /*
                     //注册监听事件
                    List<String> children = null;
                    try {
                        children = zooKeeper.getChildren("/", true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("==========");
                    children.forEach(e-> {

                        System.out.println(e);
                    });
                    System.out.println("=============");
                    */
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("拿到zk链接... 会初始化两个子线程 一个send 一个listener"+zooKeeper);
    }

    /**
     * 创建节点
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void createNode() throws KeeperException, InterruptedException {
        //创建持久节点
        System.out.println("主程序.................");
        String returnVal = zooKeeper.create("/codetest3", "xujianhong3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(returnVal);

        //创建临时节点
        String returnValTwo = zooKeeper.create("/codetest2", "xujianhong3".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(returnValTwo);
    }


    /**
     * 获取子节点 并监听节点的变化
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void getChildrenNode() throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren("/", true);
        System.out.println("--------------------------------");
        children.forEach(e-> {

            System.out.println(e);
        });
        System.out.println("--------------------------------");
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }


    /**
     * 判断节点是否是存在
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void judgeNodeExist() throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists("/codetest3", false);
        System.out.println(stat==null? "不存在":"存在的");
        if(null != stat){
          zooKeeper.delete("/codetest3",stat.getVersion());
        }
    }







}
