package br.edu.ifce.entity;

import java.util.Date;
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
import javax.persistence.Table;

import br.edu.ifce.util.IGenericEntity;

/**
 * 
 * 
 * @author Edivando Alves
 * 
 */
@Entity
@Table(name = "pessoa")
@NamedQueries({@NamedQuery(name = "Pessoa", query = "from Pessoa p")})
public class Pessoa implements IGenericEntity<Pessoa> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pessoa")
	private Integer id;
	
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "sexo", nullable = true)
	private Character sexo;
	
	@Column(name = "cpf", nullable = true)
	private String cpf;
	
	@Column(name = "email", length = 80, nullable = false)
	private String email;
	
	@Column(name = "dt_nascimento", nullable = true)
	private Date dtNascimento;
	
	@Column(name = "url_lattes", length = 80, nullable = true)
	private String urlLattes;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy="pessoa",fetch=FetchType.EAGER)
	private List<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getUrlLattes() {
		return urlLattes;
	}

	public void setUrlLattes(String urlLattes) {
		this.urlLattes = urlLattes;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return nome;
	}
}

