package spring.redis.web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories // Redis Repository 활성화
@RequiredArgsConstructor
@Configuration
public class RedisCacheConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;



    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

//    @Bean
//    public RedisTemplate<?,?> redisTemplate() {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        return redisTemplate;
//    }

//    //RedisCacheManager를 Bean으로 등록하면 기본 CacheManager를 RedisCacheManager로 사용함.
//    @Bean(name = "cacheManager") // cache에서 Redis를 사용하기 위해 설정
//    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
//                .disableCachingNullValues() // null value 캐시 안함
//                .entryTtl(Duration.ofSeconds(CacheKey.DEFAULT_EXPIRE_SEC)) // cache 기본 유효시간 설정
//                .computePrefixWith(CacheKeyPrefix.simple())
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
//
//        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
//        cacheConfigurationMap.put(CacheKey.POST, RedisCacheConfiguration.defaultCacheConfig())
//                .entryTtl(Duration.ofSeconds(CacheKey.POST_EXPIRE_SEC));
//
//        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory).cacheDefaults(configuration).build();
////                .withInitialCacheConfigurations(cacheConfigurationMap).build();
//    }

}
