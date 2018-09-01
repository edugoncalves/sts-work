package br.com.eagrobusiness.api.dao.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1885811014730423700L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	private String nome;
	private String login;
	private String email;
	private String senha;
	
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "idusuario",referencedColumnName="id"), 
			inverseJoinColumns = @JoinColumn(name = "idperfil",referencedColumnName="id"))
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Perfil> perfis;
	private boolean ativo;

}
