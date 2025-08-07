package com.aurostacktech.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.aurostacktech.product.repository")
@EntityScan(basePackages = "com.aurostacktech.product.model")
public class ProductManageApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductManageApplication.class, args);
	}
}
