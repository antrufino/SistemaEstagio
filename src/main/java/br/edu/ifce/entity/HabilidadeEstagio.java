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
@Table(name = "habilidade_estagio")
@NamedQueries({ @NamedQuery(name = "HabilidadeEstagio", query = "from HabilidadeEstagio u") })
public class HabilidadeEstagio implements IGenericEntity<HabilidadeEstagio>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_habilidade_estagio")
	private Integer id;
	
	@Column(name="peso")
	private Integer peso;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_nivel_habilidade")
	private NivelHabilidade nivelHabilidade;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_habilidade")
	private Habilidade habilidade;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_estagio")
	private Estagio estagio;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public NivelHabilidade getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(NivelHabilidade nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public Estagio getEstagio() {
		return estagio;
	}

	public void setEstagio(Estagio estagio) {
		this.estagio = estagio;
	}

	@Override
	public String toString() {
		return id.toString();
	}
}
