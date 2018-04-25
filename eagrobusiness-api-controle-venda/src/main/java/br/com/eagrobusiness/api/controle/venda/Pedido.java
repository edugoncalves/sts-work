package br.com.eagrobusiness.api.controle.venda;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pedidos")
public class Pedido {

	@Id 
	private int id;
	private LocalDate data;
	
}
