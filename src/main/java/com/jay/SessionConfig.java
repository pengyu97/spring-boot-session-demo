package com.jay;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author xiang.wei
 * @date 2020/1/14 18:53
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = -1)
public class SessionConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(host, port);
        lettuceConnectionFactory.setDatabase(database);
        return lettuceConnectionFactory;
    }

    @Bean
    public DefaultCookieSerializer defaultCookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookiePath("/");
        return defaultCookieSerializer;
    }

}
