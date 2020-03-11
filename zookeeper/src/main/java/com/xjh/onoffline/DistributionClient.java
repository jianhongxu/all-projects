package com.xjh.onoffline;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/11 10:49
 * @Description: 客户端
 */
public class DistributionClient {

    private String connectString = "192.168.1.5:2181,192.168.1.5:2182,192.168.1.5:2183";
    private int sessionTimeout = 2000;

    private ZooKeeper zooKeeper;

    //服务列表
    private Set<String> services = new CopyOnWriteArraySet<>();

    public static void main(String[] args) throws Exception {
        DistributionClient distributionClient = new DistributionClient();
        //1、获取zk链接
        distributionClient.connect();
        //2、获取服务端信息 并注册监听
        distributionClient.getServersInfo();
        //3、处理业务
        distributionClient.doBusniess();
    }

    private void doBusniess() throws InterruptedException {
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }

    private void getServersInfo() throws Exception {
        List<String> children = zooKeeper.getChildren("/servers", true);
        for(String chil :children ){
            byte[] data = zooKeeper.getData("/servers/" + chil, false, null);
            services.add(new String(data));
        }
        System.out.println("服务器一共有: "+services);
    }

    private void connect() throws Exception {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    services.clear();
                    getServersInfo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
