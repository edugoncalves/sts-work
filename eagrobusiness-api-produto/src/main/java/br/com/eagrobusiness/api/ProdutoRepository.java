package br.com.eagrobusiness.api;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

    @Override
    void delete(Produto deleted);
    Produto findByDescricao(String descricao);
}
