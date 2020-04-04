package com.qqxhb.spi.dubbo;
public class Dog implements IAnimal {

	@Override
	public void say() {
		System.out.println("狗吠========");
	}
}