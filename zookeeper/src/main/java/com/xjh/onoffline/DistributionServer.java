package com.xjh.onoffline;

import org.apache.zookeeper.*;

import java.util.concurrent.TimeUnit;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/11 10:40
 * @Description: 模拟上线 下线的服务
 */
public class DistributionServer {

    private String connectString="192.168.1.5:2181,192.168.1.5:2182,192.168.1.5:2183";
    private int sessionTimeout=2000;

    private ZooKeeper  zooKeeper;

    public static void main(String[] args) throws Exception{
        DistributionServer distributionServer = new DistributionServer();
        //1、创建zk链接
        distributionServer.connect();
        //2、创建上线节点(服务节点名由运行参数传入)
        distributionServer.online(args[0]);

        //3、模拟处理业务
        distributionServer.doBusniess();
    }

    private void doBusniess() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    private void online(String data) throws Exception {
        String returnValue = zooKeeper.create("/servers/server", data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("服务器上线:"+returnValue+"->"+data);
    }


    private  void connect() throws Exception{
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        });
    }

}
