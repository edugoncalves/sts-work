package br.com.eagrobusiness.web.model;

import lombok.Data;

@Data
public class UsuarioModel {

	private String username;
	private String passwrod;
	private String name;
	private String email;
	private boolean ativo;
	
}
