package br.com.eagrobusiness.infra.lib.model.usuario;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection="autorizacoes")
public class Autorizacao implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2465678310455000030L;
	@Id
	private String id;
	private String authority;

	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
