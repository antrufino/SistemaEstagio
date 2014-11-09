package br.edu.ifce.entity;

import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

@Entity
@Table(name = "estagio")
@NamedQueries({@NamedQuery(name = "Estagio", query = "select t from Estagio t")})
public class Estagio implements IGenericEntity<Estagio> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_estagio")
	private Integer id;

	@Column(name = "ds_estagio", length = 20)
	private String dsEstagio;

	@Column(name = "dt_inicio")
	private Date dtInicio;

	@Column(name = "dt_fim")
	private Date dtFim;

	@Column(name = "bolsa", precision = 2)
	private Float bolsa;

	@Column(name = "beneficios", length = 30)
	private String beneficios;

	@Column(name = "ch_semanal")
	private Integer chSemanal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa")
	private Empresa empresa;
	
	@OneToMany(mappedBy= "estagio", fetch=FetchType.LAZY)
	private List<ContatoEstagio> contatoEstagio;

	@OneToMany(mappedBy = "estagio", fetch = FetchType.LAZY)
	private List<HabilidadeEstagio> habilidadeEstagios;
	
	public String getDsEstagio() {
		return dsEstagio;
	}

	public void setDsEstagio(String dsEstagio) {
		this.dsEstagio = dsEstagio;
	}

	public Date getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Date getDtFim() {
		return dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Float getBolsa() {
		return bolsa;
	}

	public void setBolsa(Float bolsa) {
		this.bolsa = bolsa;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public Integer getChSemanal() {
		return chSemanal;
	}

	public void setChSemanal(Integer chSemanal) {
		this.chSemanal = chSemanal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<ContatoEstagio> getContatoEstagio() {
		return contatoEstagio;
	}

	public void setContatoEstagio(List<ContatoEstagio> contatoEstagio) {
		this.contatoEstagio = contatoEstagio;
	}

	public List<HabilidadeEstagio> getHabilidadeEstagios() {
		return habilidadeEstagios;
	}

	public void setHabilidadeEstagios(List<HabilidadeEstagio> habilidadeEstagios) {
		this.habilidadeEstagios = habilidadeEstagios;
	}
	
}
