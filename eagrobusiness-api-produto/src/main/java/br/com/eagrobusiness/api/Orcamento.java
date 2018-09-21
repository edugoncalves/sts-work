package br.com.eagrobusiness.api;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Orcamento {
private String idProduto;
private String nomeProduto;
private Double valorUnitario;
private Integer quantidade;
private Double total;

}
