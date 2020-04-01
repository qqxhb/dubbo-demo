package com.qqxhb.annotation.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qqxhb.annotation.provider.config.ProviderConfiguration;

public class ProviderApplication {
	public static void main(String[] args) throws Exception {
		// 使用spring的注解容器加载配置并启动
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ProviderConfiguration.class);
		context.start();
		// 阻塞服务，否则会直接关闭
		System.in.read();
		context.close();
	}
}
