package br.edu.ifce.entity;


import java.sql.Blob;

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
@Table(name = "cv")
@NamedQueries({
		@NamedQuery(name = "Cv", query = "from Cv c")
})
public class Cv implements IGenericEntity<Cv> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cv")
	private Integer id;

	@Column(name = "ds_cv", length = 5000, nullable = false)
	private String dsCv;

	@Column(name = "cv")
	private Blob cv;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsCv() {
		return dsCv;
	}

	public void setDsCv(String dsCv) {
		this.dsCv = dsCv;
	}
	
	public void setCv(Blob Cv) {
		this.cv = Cv;
	}

	public Blob getCv() {
		return cv;
	}

	@Override
	public String toString() {
		return dsCv;
	}
}
