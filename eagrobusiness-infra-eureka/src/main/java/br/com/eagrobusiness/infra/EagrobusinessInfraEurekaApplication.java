package br.com.eagrobusiness.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EagrobusinessInfraEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagrobusinessInfraEurekaApplication.class, args);
	}
}
