package com.qqxhb.api.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qqxhb.demo.api.HelloService;

/**
 * 
 * 通过DubboBootstrap方式启动服务
 *
 */
public class BootstrapConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(BootstrapConsumerApplication.class);

	public static void main(String[] args) throws Exception {
		ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
		reference.setInterface(HelloService.class);

		DubboBootstrap bootstrap = DubboBootstrap.getInstance();
		bootstrap.application(new ApplicationConfig("dubbo-api-demo-consumer"))
				.registry(new RegistryConfig("zookeeper://127.0.0.1:2181")).reference(reference).start();
		HelloService helloService = ReferenceConfigCache.getCache().get(reference);
		String message = helloService.sayHello("Dubbo Bootstrap");
		logger.info("============{}", message);

	}
}
