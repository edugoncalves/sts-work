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



/**
 * @author Eduardo da Silva Gonçalves
 * Esta classe cobre o caso de uso que trata do caso de uso manter produto e orcarmento de um produto
 * O microserviço deste cobre operações sobre produtos
 *
 */
@EnableJpaRepositories
@EnableCircuitBreaker
@RestController
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class EagrobusinessApiProdutoApplication {

	@Autowired
	private ProdutoRepository repositorio;
	

	public static void main(String[] args) {
		SpringApplication.run(EagrobusinessApiProdutoApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produtos", headers = "Accept=application/json")
	@ResponseBody
	private Iterable<Produto> getAll() {
		return repositorio.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/produto", headers = "Accept=application/json")
	private String inserir(@RequestBody Produto produto) {
	    
		boolean existe = repositorio.findByDescricao(produto.getDescricao())!=null;
		if (existe)
			return "Já existe um produto cadastrado com esta descrição";
		repositorio.save(produto);
		return produto.getId();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/produto", headers = "Accept=application/json")
	private String atualizar(@RequestBody Produto produto) {

		repositorio.save(produto);
		return produto.getId();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/produto/{id}", headers = "Accept=application/json")
	private String delete(@PathVariable("id") String id) {
		if (repositorio.existsById(id)) {
			repositorio.deleteById(id);
			return String.format("Produto deletado: %s", id);
		}
		return "nenhum produto";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto/{id}", headers = "Accept=application/json")
	@ResponseBody
	private Optional<Produto> get(@PathVariable("id") String id) {
		return repositorio.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/produto/orcamento/{id}/{quantidade}", headers = "Accept=application/json")
	@ResponseBody
	private Optional<Orcamento> getOrcamento(@PathVariable("id") String id,@PathVariable("quantidade") String quantidade) {
		final Double defaultPrice=3d;//TODO: retirar após nova carga na tabela
		Orcamento orcamento= new Orcamento();
		Optional<Produto> produto=repositorio.findById(id);
		if(produto!=null) {
		orcamento.setIdProduto(produto.get().getId());
		orcamento.setNomeProduto(produto.get().getDescricao());
		orcamento.setValorUnitario(3d);
		orcamento.setQuantidade(Integer.valueOf(quantidade));
		orcamento.setTotal(orcamento.getQuantidade()*
							(produto.get().getValorUnidade()!=null?
									produto.get().getValorUnidade():
									defaultPrice));
		}
		return Optional.of(orcamento);

	}
	
}
