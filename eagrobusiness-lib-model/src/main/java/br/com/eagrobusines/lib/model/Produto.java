package br.com.eagrobusines.lib.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="produtos")
public class Produto {
	@Id
	private String id;
	private String descricao;
	private boolean perecivel;
	private boolean embalavel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	public boolean isEmbalavel() {
		return embalavel;
	}
	public void setEmbalavel(boolean embalavel) {
		this.embalavel = embalavel;
	}
}
