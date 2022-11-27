package br.com.pilares.msstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStorageApplication.class, args);
	}

}
