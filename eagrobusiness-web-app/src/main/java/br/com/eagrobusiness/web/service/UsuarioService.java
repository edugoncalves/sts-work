package br.com.eagrobusiness.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.eagrobusiness.web.dao.entity.Perfil;
import br.com.eagrobusiness.web.dao.entity.Usuario;
import br.com.eagrobusiness.web.dao.repository.UsuarioRepository;
import br.com.eagrobusiness.web.model.UsuarioModel;
import br.com.eagrobusiness.web.model.UsuarioSecurityModel;

@Component
public class UsuarioService implements UserDetailsService {

	@Autowired
	UsuarioRepository repositorio;
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usr = repositorio.findByLogin(username);
		if (usr == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!!");
		} else {
			UsuarioSecurityModel usuario = new UsuarioSecurityModel(usr.getLogin(), usr.getSenha(), usr.isAtivo(), true,
					true, true, getAutorities(usr.getPerfis()));
			return usuario;
		}
	}

	private List<GrantedAuthority> getAutorities(List<Perfil> perfis) {

		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (Perfil perfil : perfis) {
			if (perfil.isAtivo())
				auths.add(new SimpleGrantedAuthority(perfil.getNome().toUpperCase()));
		}

		return auths;
	}

	public void salvar(UsuarioModel usuario) {
		if(usuario!=null)
		repositorio.save(bind(usuario));
	}
	
	public List<UsuarioModel> listarTodos(){
		return preencherLista(repositorio.findAll());
	}

	private List<UsuarioModel> preencherLista(List<Usuario> lista) {
    	List<UsuarioModel> usuarios = new ArrayList<UsuarioModel>();
    	for(Usuario usr:lista) {
    		usuarios.add(bind(usr));
    	}
		return usuarios;
	}

	private UsuarioModel bind(Usuario usr) {
		UsuarioModel model=null;
		if(usr!=null) {
			model=new UsuarioModel();
			model.setAtivo(usr.isAtivo());
			model.setPasswrod(usr.getSenha());
			model.setUsername(usr.getLogin());
			model.setName(usr.getNome());
			model.setEmail(usr.getEmail());
		}
		return model;
	}

	private Usuario bind(UsuarioModel usuario) {
		Usuario usr = null;
		if (usuario != null) {
			usr=new Usuario();
			usr.setEmail(usuario.getEmail());
			usr.setNome(usuario.getName());
			usr.setLogin(usuario.getUsername());
			usr.setAtivo(usuario.isAtivo());
			usr.setSenha(passwordEncoder().encode(usuario.getPasswrod()));
		}
		return usr;
	}

}
