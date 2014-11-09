/*
 * Copyright 2013-2014 J7 Soluções Inteligentes.
 *
 * by Edivando Alves 
 * Contact: edivando@j7.eti.br
 * 
 */
package br.edu.ifce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

/**
 * 
 * 
 * @author Edivando Alves
 * 
 */
@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "Usuario", query = "from Usuario u") })
public class Usuario implements IGenericEntity<Usuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "cd_email", length = 80, nullable = false)
	private String cdEmail;

	@Column(name = "cd_senha", length = 80, nullable = false)
	private String cdSenha;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;

	@OneToOne(fetch = FetchType.LAZY)
	private Foto foto;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public String getCdEmail() {
		return cdEmail;
	}

	public void setCdEmail(String cdEmail) {
		this.cdEmail = cdEmail;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCdSenha() {
		return cdSenha;
	}

	public void setCdSenha(String cdSenha) {
		this.cdSenha = cdSenha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return cdEmail;
	}
}
