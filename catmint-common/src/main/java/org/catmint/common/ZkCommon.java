package org.catmint.common;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.transaction.CuratorTransactionFinal;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * <p>Title:ZK-CLIENT 常用方法封装</p>
 * <p>Description:</p>
 *
 * @author QIQI
 * @date
 */
public class ZkCommon {

    /**
     * <p>Title:创建ZK节点</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path, payload]
     * @date 2019-12-22 11:28
     */
    public static void create(CuratorFramework client, String path, byte[] payload) throws Exception {
        client.create().forPath( path, payload );
    }

    /**
     * <p>Title:创建ZK临时节点信息，session销毁时节点销毁</p>
     * <p>Description:链表操作表达式</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path, payload]
     * @date 2019-12-22 11:29
     */
    public static void createEphemeral(CuratorFramework client, String path, byte[] payload) throws Exception {
        client.create().withMode( CreateMode.EPHEMERAL ).forPath( path, payload );
    }

    /**
     * <p>Title:创建ZK临时节点信息带序列号，session销毁时节点销毁</p>
     * <p>Description:链表操作表达式</p>
     *
     * @return java.lang.String
     * @throws
     * @author QIQI
     * @params [client, path, payload]
     * @date 2019-12-22 11:30
     */
    public static String createEphemeralSequential(CuratorFramework client, String path, byte[] payload) throws Exception {
        return client.create().withProtection().withMode( CreateMode.EPHEMERAL_SEQUENTIAL ).forPath( path, payload );
    }

    /**
     * <p>Title:对ZK节点赋值</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path, payload]
     * @date 2019-12-22 11:32
     */
    public static void setData(CuratorFramework client, String path, byte[] payload) throws Exception {
        client.setData().forPath( path, payload );
    }

    /**
     * <p>Title:异步方式对节点信息赋值</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path, payload]
     * @date 2019-12-22 11:33
     */
    public static void setDataAsync(CuratorFramework curatorFramework, String path, byte[] payload) throws Exception {
        CuratorListener listener = (client, event) -> {
        };
        curatorFramework.getCuratorListenable().addListener( listener );
        curatorFramework.setData().inBackground().forPath( path, payload );
    }

    /**
     * <p>Title:异步回调方式对节点信息赋值</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, callback, path, payload]
     * @date 2019-12-22 11:37
     */
    public static void setDataAsyncWithCallback(CuratorFramework client, BackgroundCallback callback, String path, byte[] payload) throws Exception {
        client.setData().inBackground( callback ).forPath( path, payload );
    }

    /**
     * <p>Title:删除节点数据</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path]
     * @date 2019-12-22 11:37
     */
    public static void delete(CuratorFramework client, String path) throws Exception {
        client.delete().forPath( path );
    }

    /**
     * <p>Title:强制删除一个节点，保证删除</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [client, path]
     * @date 2019-12-22 11:37
     */
    public static void guaranteedDelete(CuratorFramework client, String path) throws Exception {
        client.delete().guaranteed().forPath( path );
    }

    /**
     * <p>Title:获取节点的观察者通知</p>
     * <p>Description:</p>
     *
     * @return java.util.List<java.lang.String>
     * @throws
     * @author QIQI
     * @params [client, path]
     * @date 2019-12-22 11:38
     */
    public static List<String> watchedGetChildren(CuratorFramework client, String path) throws Exception {
        return client.getChildren().watched().forPath( path );
    }

    /**
     * <p>Title:设置节点观察通知信息</p>
     * <p>Description:</p>
     *
     * @return java.util.List<java.lang.String>
     * @throws
     * @author QIQI
     * @params [client, path, watcher]
     * @date 2019-12-22 11:39
     */
    public static List<String> watchedGetChildren(CuratorFramework client, String path, Watcher watcher) throws Exception {
        return client.getChildren().usingWatcher( watcher ).forPath( path );
    }

    /**
     * <p>Title:开启事务操作</p>
     * <p>Description:</p>
     *
     * @return org.apache.curator.framework.api.transaction.CuratorMultiTransaction
     * @throws
     * @author QIQI
     * @params [client]
     * @date 2019-12-22 20:46
     */
    public static CuratorTransactionFinal startTransaction(CuratorFramework client, String path, byte[] payload) throws Exception {
        return client.inTransaction().create().forPath( path, payload ).and();
    }

    /**
     * <p>Title:提交事务</p>
     * <p>Description:</p>
     *
     * @return void
     * @throws
     * @author QIQI
     * @params [transaction]
     * @date 2019-12-22 20:47
     */
    public static void commitTransaction(CuratorTransactionFinal transaction) throws Exception {
        transaction.commit();
    }
}