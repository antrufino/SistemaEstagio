/*
 *
 * by João Victor Castelo 
 * Contact: vitorcastelo.m@gmail.com
 * 
 */
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
 * @author João Victor Castelo
 * 
 */
@Entity
@Table(name = "turno")
@NamedQueries({
		@NamedQuery(name = "Turno", query = "from Turno t")
})
public class Turno implements IGenericEntity<Turno> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_turno")
	private Integer id;

	@Column(name = "ds_turno", length = 80, nullable = false)
	private String dsTurno;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsTurno() {
		return dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	@Override
	public String toString() {
		return dsTurno;
	}
}
