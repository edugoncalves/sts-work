package br.com.eagrobusiness.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eagrobusiness.api.dao.entity.Recurso;


@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
}
