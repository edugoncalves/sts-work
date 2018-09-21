package br.com.eagrobusiness.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;



/**
 * @author Eduardo da Silva Gonçalves
 * Esta classe cobre o caso de uso que trata do caso de uso manter produto e orcarmento de um produto
 * O microserviço deste cobre operações sobre produtos
 *
 */
@EnableJpaRepositories
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class EagrobusinessApiProdutoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EagrobusinessApiProdutoApplication.class, args);
	}
}
