package com.qqxhb.spi.dubbo;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class DubboSPI {

	public static void main(String[] args) {
		// 根据扩展类型实例化 ExtensionLoader
		ExtensionLoader<IAnimal> extensionLoader = ExtensionLoader.getExtensionLoader(IAnimal.class);
		// 获取SPI注解中指定的默认扩展实现
		extensionLoader.getDefaultExtension().say();
		// 根据配置文件中的key获取对应的扩展
		extensionLoader.getExtension("dog").say();
		extensionLoader.getExtension("cat").say();
	}

}
