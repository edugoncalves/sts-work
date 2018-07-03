package br.com.eagrobusiness.infra.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.eagrobusiness.infra.lib.model.usuario.Usuario;
import br.com.eagrobusiness.infra.lib.repository.UsuarioRepository;


@Service("usuarioService")
public class UsuarioService implements UserDetailsService{

	@Autowired
	private UsuarioRepository repositorio;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usr=repositorio.findByUsername(username);
		if(usr==null) throw new UsernameNotFoundException("usuario não encontrado, por favor, verifique as informações fornecidas.");
		return usr;
		
	}
	public void salvar(Usuario usr) {
		repositorio.save(usr);
	}
	public void deletar(Usuario usr) {
		repositorio.delete(usr);
	}
	public Iterable<Usuario>buscarTodos(){
		return repositorio.findAll();
	}

}
