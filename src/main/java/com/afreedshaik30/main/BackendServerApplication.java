package com.afreedshaik30.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.afreedshaik30.main.fegin_client")
public class BackendServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendServerApplication.class, args);
	}

}
