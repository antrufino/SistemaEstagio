package br.edu.ifce.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;


/**
 * 
 * 
 * @author Ulysses Rocha
 * 
 */
@Entity
@Table(name = "contato_telefone")
@NamedQueries({
		@NamedQuery(name = "ContatoTelefone", query = "select c from ContatoTelefone c")
})
public class ContatoTelefone implements IGenericEntity<ContatoTelefone> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contato")
	private Integer id;

	@Column(name = "ds_telefone", length = 15, nullable = false)
	private String dsTelefone;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTelefone() {
		return dsTelefone;
	}

	public void setDsTelefone(String dsTelefone) {
		this.dsTelefone = dsTelefone;
	}

	@Override
	public String toString() {
		return dsTelefone;
	}
}
