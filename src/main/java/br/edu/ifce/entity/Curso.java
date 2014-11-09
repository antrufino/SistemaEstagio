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
@Table(name = "curso")
@NamedQueries({
		@NamedQuery(name = "Curso", query = "select c from Curso c")
})
public class Curso implements IGenericEntity<Curso> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curso")
	private Integer id;

	@Column(name = "ds_curso", length = 80, nullable = false)
	private String dsCurso;
	
	//@OneToMany(mappedBy = "Curso", fetch = FetchType.LAZY)
	//private List<Aluno> aluno;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsCurso() {
		return dsCurso;
	}

	public void setDsCurso(String dsCurso) {
		this.dsCurso = dsCurso;
	}

	@Override
	public String toString() {
		return dsCurso;
	}
}
