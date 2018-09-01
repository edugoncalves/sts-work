package br.com.eagrobusiness.api.model;

import lombok.Data;

@Data
public class UsuarioModel {

	private String username;
	private String passwrod;
	private String name;
	private String email;
	private boolean ativo;
	
}
