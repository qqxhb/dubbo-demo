package com.qqxhb.api.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qqxhb.api.provider.impl.HelloServiceImpl;
import com.qqxhb.demo.api.HelloService;

/**
 * 
 * 通过DubboBootstrap方式启动服务
 *
 */
public class BootstrapProviderApplication {
	private static final Logger logger = LoggerFactory.getLogger(ExportProviderApplication.class);

	public static void main(String[] args) throws Exception {
		ServiceConfig<HelloServiceImpl> service = new ServiceConfig<>();
		service.setInterface(HelloService.class);
		service.setRef(new HelloServiceImpl());

		DubboBootstrap bootstrap = DubboBootstrap.getInstance();
		bootstrap.application(new ApplicationConfig("dubbo-api-demo-provider"))
				.registry(new RegistryConfig("zookeeper://127.0.0.1:2181")).service(service).start();
		logger.info("dubbo service started......");
		bootstrap.await();
	}
}
