package br.com.eagrobusiness.api.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eagrobusiness.api.dao.entity.Perfil;

@Repository
public interface PefilRepository extends JpaRepository<Perfil, Integer>{

}
