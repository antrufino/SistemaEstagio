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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

@Entity
@Table(name = "empresa")
@NamedQueries({ @NamedQuery(name = "Empresa", query = "select e from Empresa e") })
public class Empresa implements IGenericEntity<Empresa> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_empresa")
	private Integer id;

	@Column(name = "cnpj_empresa", length = 20, nullable = true)
	private String cnpj;

	@Column(name = "ds_empresa", length = 30, nullable = false)
	private String dsEmpresa;

	@Column(name = "end_empresa", length = 30, nullable = true)
	private String endereco;

	@Column(name = "foco_atividade", length = 20)
	private String foco_atividade;

	@Column(name = "site_emp", length = 20)
	private String site;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Usuario usuario;
	
	@OneToMany(mappedBy="empresa", fetch=FetchType.EAGER)
	private List<Estagio> estagio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDsEmpresa() {
		return dsEmpresa;
	}

	public void setDsEmpresa(String dsEmpresa) {
		this.dsEmpresa = dsEmpresa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFoco_atividade() {
		return foco_atividade;
	}

	public void setFoco_atividade(String foco_atividade) {
		this.foco_atividade = foco_atividade;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Estagio> getEstagio() {
		return estagio;
	}

	public void setEstagio(List<Estagio> estagio) {
		this.estagio = estagio;
	}

	@Override
	public String toString() {
		return dsEmpresa;
	}
}
