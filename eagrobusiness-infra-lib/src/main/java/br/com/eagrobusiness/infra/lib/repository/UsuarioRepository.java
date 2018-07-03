package br.com.eagrobusiness.infra.lib.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.eagrobusiness.infra.lib.model.usuario.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	Usuario findByUsername(String userName);
}
