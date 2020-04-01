package com.qqxhb.annotation.consumer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qqxhb.annotation.consumer.config.ConsumerConfiguration;
import com.qqxhb.annotation.consumer.service.ReferenceHelloService;

public class ConsumerApplication {
	public static void main(String[] args) throws Exception {
		// 加载bean的配置并启动spring容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConsumerConfiguration.class);
		context.start();
		// 从spring容器中获取提供者端暴露出的服务实现
		ReferenceHelloService helloService = context.getBean("referenceHelloService", ReferenceHelloService.class);
		System.out.println("======== result: " + helloService.sayHello("annotation-comsumer"));
		context.close();
	}
}