package com.qqxhb.xml.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderApplication {
	public static void main(String[] args) throws Exception {
		// 使用spring的xml容器加载配置并启动
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-provider.xml");
		context.start();
		//阻塞服务，否则会直接关闭
		System.in.read();
		context.close();
	}
}
