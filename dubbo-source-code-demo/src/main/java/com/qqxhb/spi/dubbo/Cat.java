package com.qqxhb.spi.dubbo;

public class Cat implements IAnimal {

	@Override
	public void say() {
		System.out.println("猫叫========");
	}
}