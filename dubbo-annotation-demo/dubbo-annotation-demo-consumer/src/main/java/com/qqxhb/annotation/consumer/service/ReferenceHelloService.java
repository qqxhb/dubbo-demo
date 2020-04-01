package com.qqxhb.annotation.consumer.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import com.qqxhb.demo.api.HelloService;

/**
 * 服务引用类（不强制要求试下服务提供者接口）
 *
 */
@Component("referenceHelloService")
public class ReferenceHelloService implements HelloService {

	@Reference // 注入或者是引用远程服务
	private HelloService helloService;

	@Override
	public String sayHello(String name) {
		return helloService.sayHello(name);
	}

}