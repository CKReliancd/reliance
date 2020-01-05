package com.atguigu.zk.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZooKeeperGetData {
	public static void main(String[] args) throws IOException, KeeperException, InterruptedException{
		//创建Zookeeper对象，建立连接
				ZooKeeper zooKeeper = new ZooKeeper("192.168.70.130:2181", 5000, new Watcher() {
					
					//当接到Zookeeper的通知后，会执行process方法
					@Override
					public void process(WatchedEvent event) {
						
						
					}
				});
				
				//调用Zookeeper对象方法获取指定节点的数据
				
				//节点路径
				String path = "/fruit";
				
				//指定一个具体的观察者对象，实现对指定节点的监控
				Watcher watcher = new Watcher() {
					
					@Override
					public void process(WatchedEvent event) {
						
						//接收到Zookeeper的通知后，会执行process()方法
						System.err.println("☆☆☆我们接收到Zookeeper的通知了！☆☆☆");
						
					}
				};
				
				//状态信息通过创建空的Stat对象提供
				Stat stat = new Stat();

				//获取节点上当前值的同时，在节点上放置一个观察者对象，开始监控
				byte[] data = zooKeeper.getData(path, watcher, stat);
				
				//把获取到的字节数组转化为String
				String result = new String(data);
				
				System.out.println("result="+result);
				
				//为了能够接收通知，当前程序需要一直运行
				while(true) {
					Thread.sleep(3000);
					System.out.println("********我还活着*********");
				}
				
		

	
	}
}
