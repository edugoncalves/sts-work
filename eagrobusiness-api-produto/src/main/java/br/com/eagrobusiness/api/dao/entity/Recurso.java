package br.com.eagrobusiness.api.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="recurso")
public class Recurso implements Serializable{
	private static final long serialVersionUID = -838041817650753644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	String nome;
	@ManyToMany(mappedBy="recursos")
	List<Perfil>perfis;
}
