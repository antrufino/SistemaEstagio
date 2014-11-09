/*
 *
 * by João Victor Castelo 
 * Contact: vitorcastelo.m@gmail.com
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
 * @author João Victor Castelo
 * 
 */
@Entity
@Table(name = "tipo_habilidade")
@NamedQueries({
		@NamedQuery(name = "TipoHabilidade", query = "select h from TipoHabilidade h")
})
public class TipoHabilidade implements IGenericEntity<TipoHabilidade> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tipo_habilidade")
	private Integer id;

	@Column(name = "ds_tipo_habilidade", length = 80, nullable = false)
	private String dsTipoHabilidade;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Habilidade> habilidade;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTipoHabilidade() {
		return dsTipoHabilidade;
	}

	public void setDsTipoHabilidade(String dsTipoHabilidade) {
		this.dsTipoHabilidade = dsTipoHabilidade;
	}

	public List<Habilidade> getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(List<Habilidade> habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public String toString() {
		return dsTipoHabilidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TipoHabilidade other = (TipoHabilidade) obj;
		if (this.id != other.id
				&& (this.id == null || !this.id
						.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 41 * hash
				+ (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}
	
}
