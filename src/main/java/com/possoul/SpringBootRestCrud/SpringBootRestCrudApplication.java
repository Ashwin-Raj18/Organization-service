
//init setup was downloaded from spring.io
package com.possoul.SpringBootRestCrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRestCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestCrudApplication.class, args);
	}

}
