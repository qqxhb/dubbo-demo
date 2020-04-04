package com.qqxhb.spi.dubbo;

import org.apache.dubbo.common.extension.SPI;

@SPI("dog")//标识ݷ为Dubbo SPI，属性值用于指定默认的扩展点名称
public interface IAnimal {
	void say();
}