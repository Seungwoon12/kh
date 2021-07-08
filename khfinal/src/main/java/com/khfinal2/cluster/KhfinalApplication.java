package com.khfinal2.cluster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.khfinal2.cluster.repository")
public class KhfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhfinalApplication.class, args);
	}

}
