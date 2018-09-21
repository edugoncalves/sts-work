package br.com.eagrobusiness.api;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="produtos")
public class Produto {
	

	@Id
	private String id;
	private String descricao;
	private boolean perecivel;
	private boolean embalavel;
	private Double valorUnidade;
	private Date dataValidade;
	
}
