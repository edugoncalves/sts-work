package br.com.eagrobusiness.api;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orcamento {
private String idProduto;
private String nomeProduto;
private Double valorUnitario;
private Integer quantidade;
private Double total;
public String getIdProduto() {
	return idProduto;
}
public void setIdProduto(String idProduto) {
	this.idProduto = idProduto;
}
public String getNomeProduto() {
	return nomeProduto;
}
public void setNomeProduto(String nomeProduto) {
	this.nomeProduto = nomeProduto;
}
public Double getValorUnitario() {
	return valorUnitario;
}
public void setValorUnitario(Double valorUnitario) {
	this.valorUnitario = valorUnitario;
}
public Integer getQuantidade() {
	return quantidade;
}
public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}

}
