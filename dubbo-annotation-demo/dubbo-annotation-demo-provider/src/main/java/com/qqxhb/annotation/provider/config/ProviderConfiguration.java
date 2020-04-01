package com.qqxhb.annotation.provider.config;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//使用dubbo，并制定扫描包
@EnableDubbo(scanBasePackages = "com.qqxhb.annotation.provider")
//指定配置文件
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("zookeeper://127.0.0.1:2181");
		return registryConfig;
	}
}