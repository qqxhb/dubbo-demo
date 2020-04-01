package com.qqxhb.api.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qqxhb.demo.api.HelloService;

/**
 * 
 * 通过服务导出的方式调用服务
 *
 */
public class ExportConsumerApplication {
	private static final Logger logger = LoggerFactory.getLogger(BootstrapConsumerApplication.class);

	public static void main(String[] args) throws Exception {
		ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
		reference.setApplication(new ApplicationConfig("dubbo-demo-api-consumer"));
		reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
		reference.setInterface(HelloService.class);
		HelloService service = reference.get();
		String message = service.sayHello("Dubbo Export");
		logger.info("============{}", message);
	}
}
