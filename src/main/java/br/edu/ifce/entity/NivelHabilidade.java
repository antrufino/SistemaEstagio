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
@Table(name = "nivel_habilidade")
@NamedQueries({
		@NamedQuery(name = "NivelHabilidade", query = "select u from NivelHabilidade u")
})
public class NivelHabilidade implements IGenericEntity<NivelHabilidade> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_nivel_habilidade")
	private Integer id;

	@Column(name = "ds_nivel_habilidade", length = 80, nullable = false)
	private String dsNivelHabilidade;
	
	@OneToMany(mappedBy = "nivelHabilidade", fetch = FetchType.LAZY)
	private List<HabilidadeEstagio> habilidadeEstagios;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsNivelHabilidade() {
		return dsNivelHabilidade;
	}

	public void setDsNivelHabilidade(String dsNivelHabilidade) {
		this.dsNivelHabilidade = dsNivelHabilidade;
	}

	public List<HabilidadeEstagio> getHabilidadeEstagios() {
		return habilidadeEstagios;
	}

	public void setHabilidadeEstagios(List<HabilidadeEstagio> habilidadeEstagios) {
		this.habilidadeEstagios = habilidadeEstagios;
	}

	@Override
	public String toString() {
		return dsNivelHabilidade;
	}
}
