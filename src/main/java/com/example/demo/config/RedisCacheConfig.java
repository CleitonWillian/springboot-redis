package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;

@Configuration
public class RedisCacheConfig {
	@Bean
	RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.activateDefaultTyping(
				BasicPolymorphicTypeValidator.builder().allowIfBaseType(Object.class).build(), DefaultTyping.NON_FINAL,
				JsonTypeInfo.As.WRAPPER_ARRAY);

		Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<Object>(objectMapper,
				Object.class);

		RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
				;

		return RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfig).build();
	}

}
