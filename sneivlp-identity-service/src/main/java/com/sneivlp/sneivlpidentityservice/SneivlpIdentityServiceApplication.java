package com.sneivlp.sneivlpidentityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        exclude = {
                RedisAutoConfiguration.class,
                RedisRepositoriesAutoConfiguration.class
        }
)
@ComponentScan(basePackages = {
        "com.sneivlp.sneivlpidentityservice",
        "com.sneivlp.sneivlpsecurity",
        "com.sneivlpcommon"
})
public class SneivlpIdentityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SneivlpIdentityServiceApplication.class, args);
    }

}
