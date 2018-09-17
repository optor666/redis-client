package com.optor666.redis.redis_client.core;

import com.optor666.redis.redis_client.bean.Tuple;

import java.util.List;

/**
 * Created by optor666 on 2018/6/28.
 */
public interface CmdInterface {

    // Key
    boolean del(String key);

    List<String> sort(String key, boolean alpha, int offset, int count, boolean asc);

    String type(String key);

    String randomkey();

    // String
    String get(String key);

    boolean set(String key, String value);

    // Hash

    // List
    int llen(String key);

    List<String> lrange(String key, int start, int end); // start、end 均是从 0 开始，返回结果集为 [start - end]

    // Set
    boolean sismember(String key, String member);

    // Sorted Set
    int zcard(String key);

    String zrange(String key, int start, int end);

    List<Tuple> zrangeWithScores(String key, int start, int end);

    List<Tuple> zrevrangeWithScores(String key, int start, int end);

    // HyperLogLog

    // Geo

    // Pub/Sub
    int publish(String channel, String msg);

    void psubscribe(String topic, TopicMessageListener listener);

    void subscribe(String channel, ChannelMessageListener listener);

    // Transaction

    // Script

    // Connection
    boolean select(int dbNum);

    // Server
    long dbsize();

    String info();


}
