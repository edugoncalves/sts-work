package br.com.eagrobusiness.infra.lib.model.usuario;

import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection="usuarios")
public  class Usuario implements UserDetails{

	private static final long serialVersionUID = 1446034401447392404L;
	@Id
	private String id;
	private Collection<? extends GrantedAuthority> authorities;
	private String passowrd;
	private String username;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean enabled;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return passowrd;
	}

	public String getUsername() {
		return username;
	}
	
	

	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		return accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}
	

}
