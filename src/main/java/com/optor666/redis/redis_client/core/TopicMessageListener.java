package com.optor666.redis.redis_client.core;

/**
 * Created by optor666 on 2018/6/7.
 */
public interface TopicMessageListener {

    void handle(String channel, String msg);

}
