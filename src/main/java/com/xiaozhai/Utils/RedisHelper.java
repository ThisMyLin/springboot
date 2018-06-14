package com.xiaozhai.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Component
public class RedisHelper {

    @Autowired
    private JedisPool jedisPool;

    private static Logger logger = LoggerFactory.getLogger(RedisHelper.class);

    /**
     * 根据key获取缓存数据
     *
     * @param key
     * @return
     */
    public String get(String key) throws Exception {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            logger.info("连接redis失败，jedis："+jedis);
            logger.error(e.getMessage());
            return null;
        }finally {
            if(jedis != null){
                jedis.close();
            }
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
            return jedis.keys(prefix);
        } catch (Exception e) {
            logger.info("连接redis失败，jedis："+jedis);
            logger.error(e.getMessage());
            return null;
        }finally {
            if(jedis != null){
                jedis.close();
            }
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
            jedis.set(key, value);
        } catch (Exception e) {
            logger.info("连接redis失败，jedis："+jedis);
            logger.error(e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
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
            jedis.set(key, value);
            jedis.expire(key, expire);
        } catch (Exception e) {
            logger.info("连接redis失败，jedis："+jedis);
            logger.error(e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
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
            jedis.del(key);
        } catch (Exception e) {
            logger.info("连接redis失败，jedis："+jedis);
            logger.error(e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

}
