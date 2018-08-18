package br.com.eagrobusiness.web.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="perfil")
public class Perfil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5403076585618110909L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	String nome;
	
	boolean ativo;
	
	@ManyToMany
	@JoinTable(name="recurso_perfil",joinColumns=@JoinColumn(name="idperfil",referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="idrecurso",referencedColumnName="id"))
	List<Recurso> recursos;
	
	@ManyToMany(mappedBy="perfis")
	List<Usuario> usuarios;

}
