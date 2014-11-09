/**
 * @author Katarina Hachém
 */

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

@Entity
@Table(name = "aluno")
@NamedQueries({ @NamedQuery(name = "Aluno", query = "select u from Aluno u") })
public class Aluno implements IGenericEntity<Aluno> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aluno")
	private Integer id;

	@Column(name = "matricula", length = 80, nullable = false)
	private String matricula;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_habilidade")
	private List<Habilidade> habilidades;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return matricula;
	}

}