package br.com.eagrobusiness.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.eagrobusiness.web.dao.entity.Perfil;
import br.com.eagrobusiness.web.dao.entity.Usuario;
import br.com.eagrobusiness.web.dao.repository.UsuarioRepository;
import br.com.eagrobusiness.web.model.UsuarioSecurityModel;


@Component
public class UsuarioService implements  UserDetailsService{

	@Autowired
	UsuarioRepository repositorio;
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usr= repositorio.findByLogin(username);
		if(usr==null) {
			throw new UsernameNotFoundException("Usuário não encontrado!!");
			}else {
				UsuarioSecurityModel usuario=new UsuarioSecurityModel
						(usr.getLogin(), usr.getSenha(), usr.isAtivo(), 
								true, true, true, getAutorities(usr.getPerfis()));
				return usuario;
			}
	}



	private List<GrantedAuthority> getAutorities(List<Perfil> perfis) {

		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for(Perfil perfil:perfis) {
			if(perfil.isAtivo())
			auths.add(new SimpleGrantedAuthority(perfil.getNome().toUpperCase()));
		}
		
		return auths;
	}

}
