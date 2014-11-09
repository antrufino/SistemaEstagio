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
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

@Entity
@Table(name = "contato_estagio")
@NamedQueries({
	@NamedQuery(name = "ContatoEstagio", query = "select ce from ContatoEstagio ce")})
public class ContatoEstagio implements IGenericEntity<ContatoEstagio> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_contato_estagio")
	private Integer id;

	@Column(name = "ds_estagio", length = 20)
	private String dsEstagio;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_estagio")
	private Estagio estagio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsEstagio() {
		return dsEstagio;
	}

	public void setDsEstagio(String dsEstagio) {
		this.dsEstagio = dsEstagio;
	}

	public Estagio getEstagio() {
		return estagio;
	}

	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}
	
	
	
}
