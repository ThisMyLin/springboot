package com.xiaozhai.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisPoolFactory {

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.max.total}")
    private int maxTotal;

    @Value("${spring.redis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.redis.testOnCreate}")
    private boolean testOnCreate;

    @Value("${spring.redis.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.redis.timeout}")
    private int timeOut;

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnCreate(testOnCreate);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig jedisPoolConfig = jedisPoolConfig();
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeOut);
        return jedisPool;
    }
}
