package com.qqxhb.spi.java;

import java.util.ServiceLoader;

public class JavaSPI {

	public static void main(String[] args) {
		ServiceLoader<IAnimal> serviceLoader = ServiceLoader.load(IAnimal.class);
		serviceLoader.forEach(IAnimal::say);
	}

}
