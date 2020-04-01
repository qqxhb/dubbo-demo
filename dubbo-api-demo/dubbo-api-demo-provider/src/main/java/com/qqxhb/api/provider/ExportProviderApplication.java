package com.qqxhb.api.provider;

import java.util.concurrent.CountDownLatch;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qqxhb.api.provider.impl.HelloServiceImpl;
import com.qqxhb.demo.api.HelloService;

/**
 * 
 * 通过服务导出的方式启动服务
 *
 */
public class ExportProviderApplication {
	private static final Logger logger = LoggerFactory.getLogger(ExportProviderApplication.class);

	public static void main(String[] args) throws Exception {
		ServiceConfig<HelloServiceImpl> service = new ServiceConfig<>();
		service.setInterface(HelloService.class);
		service.setRef(new HelloServiceImpl());

		service.setApplication(new ApplicationConfig("dubbo-api-demo-provider"));
		service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
		service.export();
		logger.info("dubbo service started......");
		new CountDownLatch(1).await();
	}
}
