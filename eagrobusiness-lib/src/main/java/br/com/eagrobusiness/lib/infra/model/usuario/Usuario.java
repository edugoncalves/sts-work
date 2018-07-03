package br.com.eagrobusiness.lib.infra.model.usuario;

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
		// TODO Auto-generated method stub
		return passowrd;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	

}
