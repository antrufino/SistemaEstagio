package br.edu.ifce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

@Entity
@Table(name = "habilidade")
@NamedQueries({ @NamedQuery(name = "Habilidade", query = "select u from Habilidade u") })
public class Habilidade implements IGenericEntity<Habilidade> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_habilidade")
	private Integer id;

	@Column(name = "ds_habilidade")
	private String dsHabilidade;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_habilidade")
	private TipoHabilidade tipoHabilidade;

	@OneToMany(mappedBy = "habilidade", fetch = FetchType.LAZY)
	private List<HabilidadeEstagio> habilidadeEstagios;

	@ManyToMany(mappedBy = "habilidades", fetch = FetchType.EAGER)
	private List<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDsHabilidade() {
		return dsHabilidade;
	}

	public void setDsHabilidade(String dsHabilidade) {
		this.dsHabilidade = dsHabilidade;
	}

	public TipoHabilidade getTipoHabilidade() {
		return tipoHabilidade;
	}

	public void setTipoHabilidade(TipoHabilidade tipoHabilidade) {
		this.tipoHabilidade = tipoHabilidade;
	}

	public List<HabilidadeEstagio> getHabilidadeEstagios() {
		return habilidadeEstagios;
	}

	public void setHabilidadeEstagios(List<HabilidadeEstagio> habilidadeEstagios) {
		this.habilidadeEstagios = habilidadeEstagios;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return dsHabilidade;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Habilidade other = (Habilidade) obj;
		if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 41 * hash + (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}
}
