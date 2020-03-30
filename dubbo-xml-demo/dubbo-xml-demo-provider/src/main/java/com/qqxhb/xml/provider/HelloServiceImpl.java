package com.qqxhb.xml.provider;

import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qqxhb.demo.api.HelloService;

public class HelloServiceImpl implements HelloService {
	private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

	public String sayHello(String name) {
		logger.info("========Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
		return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
	}
}
