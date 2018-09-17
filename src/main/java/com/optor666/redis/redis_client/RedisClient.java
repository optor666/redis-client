package com.optor666.redis.redis_client;

import com.optor666.redis.redis_client.bean.RedisInfo;
import com.optor666.redis.redis_client.bean.Tuple;
import com.optor666.redis.redis_client.core.ChannelMessageListener;
import com.optor666.redis.redis_client.core.CmdFactory;
import com.optor666.redis.redis_client.core.CmdInterface;
import com.optor666.redis.redis_client.core.TopicMessageListener;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by optor666 on 2018/6/6.
 */
public class RedisClient {

    private String host;

    private int port;

    private Socket socket;

    private CmdInterface cmd;

    public RedisClient() {
        this("127.0.0.1", 6379);
    }

    public static RedisClient getRedisClient(String hostPortDb, boolean loggerSwitch) {
        String[] pieces = hostPortDb.split(":");
        RedisClient client = new RedisClient(pieces[0], Integer.parseInt(pieces[1]), loggerSwitch);
        client.select(Integer.parseInt(pieces[2]));
        return client;
    }

    public RedisClient(String host, int port) {
        this(host, port, false);
    }

    public RedisClient(String host, int port, boolean loggerSwitch) {
        this.host = host;
        this.port = port;

        try {
            socket = new Socket(host, port);
            cmd = CmdFactory.getInstance(socket.getInputStream(), socket.getOutputStream(), loggerSwitch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
//            socket.getOutputStream().close();
//            socket.getInputStream().close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Key
    public boolean del(String key) {
        return cmd.del(key);
    }

    public List<String> sort(String key, boolean alpha, int offset, int count, boolean asc) {
        return cmd.sort(key, alpha, offset, count, asc);
    }

    public String type(String key) {
        return cmd.type(key);
    }

    public String randomkey() {
        return cmd.randomkey();
    }


    // String
    public String get(String key) {
        return cmd.get(key);
    }

    public boolean set(String key, String value) {
        return cmd.set(key, value);
    }

    // Hash

    // List
    public int llen(String key) {
        return cmd.llen(key);
    }

    public List<String> lrange(String key, int start, int end) {
        return cmd.lrange(key, start, end);
    }

    // Set
    public boolean sismember(String key, String member) {
        return cmd.sismember(key, member);
    }

    // Sorted Set
    public int zcard(String key) {
        return cmd.zcard(key);
    }

    public String zrange(String key, int start, int end) {
        return cmd.zrange(key, start, end);
    }

    public List<Tuple> zrangeWithScores(String key, int start, int end) {
        return cmd.zrangeWithScores(key, start, end);
    }

    public List<Tuple> zRevRangeWithScores(String key, int start, int end) {
        return cmd.zrevrangeWithScores(key, start, end);
    }

    // HyperLogLog

    // Geo

    // Pub/Sub
    public int publish(String channel, String msg) {
        return cmd.publish(channel, msg);
    }

    public void psubscribe(String topic, TopicMessageListener listener) {
        cmd.psubscribe(topic, listener);
    }

    public void subscribe(String channel, ChannelMessageListener listener) {
        cmd.subscribe(channel, listener);
    }

    // Transaction

    // Script

    // Connection
    public boolean select(int dbNum) {
        return cmd.select(dbNum);
    }

    // Server
    public List<Long> allDbsize() {
        List<Long> res = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            res.add(dbsize(i));
        }
        select(0); // 这里默认重置为 0 号数据库
        return res;
    }


    public long dbsize(int dbNum) {
        if (select(dbNum)) {
            return dbsize();
        }
        return 0;
    }

    public long dbsize() {
        return cmd.dbsize();
    }

    public String info() {
        return cmd.info();
    }

    public RedisInfo infoBean() {
        RedisInfo res = new RedisInfo();

        String info = info();
        String[] lines = info.split("\n");
        for (String line : lines) {
            String[] kvArr = line.split(":");
            String key = kvArr[0];
            String value = kvArr[1];
            switch (key) {
                case "used_cpu_sys":
                    res.setUsedCpuSys(Double.parseDouble(value));
                    break;
                case "used_cpu_user":
                    res.setUsedCpuUser(Double.parseDouble(value));
                    break;
                case "used_cpu_sys_children":
                    res.setUsedCpuSysChildren(Double.parseDouble(value));
                    break;
                case "used_cpu_user_children":
                    res.setUsedCpuUserChildren(Double.parseDouble(value));
                    break;
                case "used_memory":
                    res.setUsedMemory(Long.parseLong(value));
                    break;
                case "used_memory_human":
                    res.setUsedMemoryHuman(value);
                    break;
                case "used_memory_rss":
                    res.setUsedMemoryRss(Long.parseLong(value));
                    break;
                case "used_memory_peak":
                    res.setUsedMemoryPeak(Long.parseLong(value));
                    break;
                case "used_memory_peak_human":
                    res.setUsedMemoryPeakHuman(value);
                    break;
                case "mem_fragmentation_ratio":
                    res.setMemFragmentationRatio(Double.parseDouble(value));
            }
        }
        return res;
    }


}
