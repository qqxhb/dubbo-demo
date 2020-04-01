package com.qqxhb.annotation.consumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.qqxhb.annotation.consumer.service")
@PropertySource("classpath:/dubbo-consumer.properties")
@ComponentScan(value = { "com.qqxhb.annotation.consumer.service" })
public class ConsumerConfiguration {

}