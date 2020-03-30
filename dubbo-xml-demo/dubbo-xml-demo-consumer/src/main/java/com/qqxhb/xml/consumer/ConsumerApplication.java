package com.qqxhb.xml.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qqxhb.demo.api.HelloService;

public class ConsumerApplication {
	public static void main(String[] args) throws Exception {
		// 加载bean的配置并启动spring容器
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
		context.start();
		// 从spring容器中获取提供者端暴露出的服务实现
		HelloService helloService = context.getBean("helloService", HelloService.class);
		System.out.println("======== result: " + helloService.sayHello("xml-comsumer"));
		context.close();
	}
}