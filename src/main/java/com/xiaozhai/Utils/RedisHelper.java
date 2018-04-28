package com.xiaozhai.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Component
public class RedisHelper {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 根据key获取缓存数据
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 获取指定前缀的所有key
     *
     * @param prefix
     * @return
     */
    public Set<String> keys(String prefix) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        try {
            return jedis.keys(prefix);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }


    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 根据key设置缓存数据，如果以前存在更新，如果以前没有添加
     *
     * @param key
     * @param value
     * @param expire
     */
    public void set(String key, String value, int expire) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jedis.set(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

    /**
     * 根据key删除缓存数据
     *
     * @param key
     */
    public void del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisPool.returnResourceObject(jedis);
        }
    }

}
