package br.com.eagrobusiness.infra.lib.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.eagrobusiness.infra.lib.model.usuario.Autorizacao;

public interface AutorizacaoRepsoitory extends CrudRepository<Autorizacao, String> {
	Autorizacao findByAuthority(String auth);

}
