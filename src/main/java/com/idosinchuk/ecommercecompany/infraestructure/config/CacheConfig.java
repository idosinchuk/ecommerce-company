package com.idosinchuk.ecommercecompany.infraestructure.config;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

  public static final String PRICES_CACHE = "prices";

  @Bean
  @Override
  public CacheManager cacheManager() {
    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager(PRICES_CACHE);
    caffeineCacheManager.setCaffeine(caffeineCacheBuilder());
    return caffeineCacheManager;
  }

  Caffeine<Object, Object> caffeineCacheBuilder() {
    return Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES)
        .recordStats();
  }

}