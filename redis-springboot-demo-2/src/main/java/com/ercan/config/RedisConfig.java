package com.ercan.config;

import com.ercan.constant.CacheConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching
public class RedisConfig {

    @Value("${redis.cache.ttl}")
    private int entryTtl;

    @Value("${redis.cache.countryNames.ttl}")
    private int countryNamesEntryTtl;

    @Value("${redis.cache.countryISO.ttl}")
    private int countryISOsEntryTtl;


    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(entryTtl))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return builder -> {
            var countryNamesCacheConf = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(countryNamesEntryTtl));
            builder.withCacheConfiguration(CacheConstant.CacheNames.COUNTRY_NAMES, countryNamesCacheConf);

            var countryISOsCacheConf = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(countryISOsEntryTtl));
            builder.withCacheConfiguration(CacheConstant.CacheNames.COUNTRY_ISOs,countryISOsCacheConf);
        };
    }

}
