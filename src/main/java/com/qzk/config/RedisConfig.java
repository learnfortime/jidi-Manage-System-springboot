package com.qzk.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;


@Configuration
public class RedisConfig {
    /**
     * 实例化具体的缓存配置!
     *    设置缓存方式JSON
     *    设置缓存时间 单位秒
     * @param ttl
     * @return
     */
    private RedisCacheConfiguration redisCacheConfiguration(Long ttl){
        //设置jackson序列化工具
        Jackson2JsonRedisSerializer<Object> objectJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        //常见jackson的对象映射器,并设置一些基本属性
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(MapperFeature.USE_ANNOTATIONS,false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY);
        objectJackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(ttl))//设置缓存时间
                .disableCachingNullValues()
                .serializeKeysWith(keyPair())
                .serializeValuesWith(valuePair());
    }
    //配置缓存管理器
    @Bean("cacheManagerHour")
    @Primary  //同类型,多个bean,默认生效! 默认缓存时间1小时!  可以选择!
    public CacheManager cacheManagerHour(RedisConnectionFactory factory){
        //缓存时间一小时
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration( 3600L);
        //构建缓存对象
        return RedisCacheManager.builder(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();
    }

    //缓存一天的配置
    @Bean(name ="cacheManagerDay")
    public RedisCacheManager cacheManagerDay(RedisConnectionFactory factory){
        //缓存时间为一天
        RedisCacheConfiguration redisCacheConfiguration = redisCacheConfiguration(24 * 3600L);
        return RedisCacheManager.builder(factory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .build();
    }

    /**
     * 配置键序列化
     * @return String序列化
     */
    @Bean
    RedisSerializationContext.SerializationPair<String> keyPair(){
        return RedisSerializationContext.SerializationPair.fromSerializer( new StringRedisSerializer());
    }

    /**
     * 配置值序列化
     * @return GenericJackson2JsonRedisSerializer序列化Object
     */
    @Bean
    RedisSerializationContext.SerializationPair<Object> valuePair(){
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }
    /**
     * 配置jdk缓存前缀问题   默认情况jdk读取缓存会使用自己的default配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 使用 StringRedisSerializer 来序列化和反序列化 redis 的 key 值
        template.setKeySerializer(new StringRedisSerializer());

        // 使用 Jackson2JsonRedisSerializer 来序列化和反序列化 redis 的 value 值
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        serializer.setObjectMapper(mapper);
        template.setValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }
}

