package com.optor666.redis.redis_client;

import com.optor666.redis.redis_client.RedisClient;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by optor666 on 2018/8/26.
 */
public class RedisClientTester {

    private static RedisClient client;

    private static String key;

    private static String value;

    @BeforeClass
    public static void prepare() {
//        client = new RedisClient();
        client = new RedisClient("127.0.0.1", 6379, true);
        key = "key";
        value = "value";
    }

    // Key
    @Test
    public void testDel() {
        boolean res = client.set(key, value);
        assertTrue(res);
        res = client.del(key);
        assertTrue(res);
    }

    // String
    @Test
    public void testGet() {
        boolean res = client.set(key, value);
        assertTrue(res);
        String str = client.get(key);
        assertEquals(value, str);

    }
    @Test
    public void testSet() {
        boolean res = client.set(key, value);
        assertTrue(res);
    }

    @AfterClass
    public static void destroy() {
        client.close();
    }
}
