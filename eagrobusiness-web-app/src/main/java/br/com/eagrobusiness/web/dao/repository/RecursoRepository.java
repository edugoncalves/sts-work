package br.com.eagrobusiness.web.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.eagrobusiness.web.dao.entity.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
}
