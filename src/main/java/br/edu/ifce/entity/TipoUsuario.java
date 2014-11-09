/*
 * Copyright 2013-2014 J7 Soluções Inteligentes.
 *
 * by Edivando Alves 
 * Contact: edivando@j7.eti.br
 * 
 */
package br.edu.ifce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

/**
 * 
 * 
 * @author Edivando Alves
 * 
 */
@Entity
@Table(name = "tipo_usuario")
@NamedQueries({
		@NamedQuery(name = "TipoUsuario", query = "from TipoUsuario u")
})
public class TipoUsuario implements IGenericEntity<TipoUsuario> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_usuario")
	private Integer id;

	@Column(name = "ds_tipo_usuario", length = 80, nullable = false)
	private String dsTipoUsuario;
	
	@Column(name = "cd_pagina_acesso", length = 250)
	private String cdPaginaAcesso;
	
	@OneToMany(mappedBy = "tipoUsuario", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTipoUsuario() {
		return dsTipoUsuario;
	}

	public void setDsTipoUsuario(String dsTipoUsuario) {
		this.dsTipoUsuario = dsTipoUsuario;
	}

	public String getCdPaginaAcesso() {
		return cdPaginaAcesso;
	}
	
	public void setCdPaginaAcesso(String cdPaginaAcesso) {
		this.cdPaginaAcesso = cdPaginaAcesso;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return dsTipoUsuario;
	}
}
