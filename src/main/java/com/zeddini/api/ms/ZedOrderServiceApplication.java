package com.zeddini.api.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient         // To enable Eureka client (Register of the MS)
@EnableFeignClients // To enable Open Feign client
public class ZedOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZedOrderServiceApplication.class, args);
	}

}
