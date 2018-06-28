package com.jtemp.test.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class ZookeeperService implements Watcher {

    ZooKeeper zooKeeper;

    public ZookeeperService() throws IOException {
        zooKeeper = new ZooKeeper("101.200.132.111:2181", 3000, this);
    }

    @Override
    public void process(WatchedEvent event) {
        switch (event.getType()) {
            case None:
                System.out.println("---state-->" + event.getState());
                try {
                    List<String> list = zooKeeper.getChildren("/", false);
                    System.out.println(list);
                    for (String s : list) {
                        List<String> children = zooKeeper.getChildren("/" + s, false);
                        System.out.println(s + " : " + children);
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case NodeCreated:
                break;
            case NodeDeleted:
                break;
            case NodeDataChanged:
                break;
            case NodeChildrenChanged:
                break;
        }
    }
}
