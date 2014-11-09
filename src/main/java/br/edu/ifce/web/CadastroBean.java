package br.edu.ifce.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.EmpresaDAO;
import br.edu.ifce.dao.PessoaDAO;
import br.edu.ifce.entity.Aluno;
import br.edu.ifce.entity.Empresa;
import br.edu.ifce.entity.Pessoa;
import br.edu.ifce.entity.TipoUsuario;
import br.edu.ifce.entity.Usuario;
import br.edu.ifce.exception.DAOException;
import br.edu.ifce.util.GenericDAO;
import br.edu.ifce.util.MD5;

@ManagedBean
@ViewScoped
public class CadastroBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Empresa empresa;
	private Pessoa pessoa;
	private Usuario usuario;
	private Aluno aluno;
	private TipoUsuario tipoUsuario;
	
	private String formAberto = "aluno";
	
	private String confirmeSenha;

	private EmpresaDAO empresaDAO = new EmpresaDAO();
	private PessoaDAO pessoaDAO = new PessoaDAO();

	
	private boolean form = false;

	public Empresa getEmpresa() {
		if(empresa == null){
			empresa = new Empresa();
		}
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}	
	
	public Pessoa getPessoa() {
		if(pessoa == null){
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Aluno getAluno() {
		if(aluno == null){
			aluno = new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Usuario getUsuario() {
		if(usuario == null){
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean form(String frm){
		return formAberto.equals(frm);		
	}
	
	public void abrirForm(String frm){
		if (frm == "empresa") {
			if (pessoa.getNome() != null) {
				pessoa = new Pessoa();
				usuario = new Usuario();
			}			
		}
		if (frm == "aluno") {
			if (pessoa.getNome() != null) {
				pessoa = new Pessoa();
				usuario = new Usuario();
			}			
		}
		formAberto = frm;	
	}
	
	public boolean isForm() {
		return form;
	}
	
	public String getConfirmeSenha() {
		return confirmeSenha;
	}

	public void setConfirmeSenha(String confirmeSenha) {
		this.confirmeSenha = confirmeSenha;
	}	
		
	
	public void addAluno(){
		abrirForm("aluno");
		this.pessoa = new Pessoa();
		this.aluno = new Aluno();
		this.usuario = new Usuario();				
	}
	
	public void addEmpresa(){
		abrirForm("empresa");
		this.pessoa = new Pessoa();
		this.usuario = new Usuario();
		this.empresa = new Empresa();
	}
	
	
	public void salvar(){		
		if (aluno.getMatricula() != null) {
			if(!usuario.getCdSenha().equals(confirmeSenha)){
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Senhas diferentes!")));		
			}
			else {
				usuario.setCdSenha( MD5.md5(usuario.getCdSenha()) );
				usuario.setCdEmail(pessoa.getEmail());
				usuario.setPessoa(pessoa);
				tipoUsuario = new TipoUsuario();
				tipoUsuario.setId(3);
				usuario.setTipoUsuario(tipoUsuario);
				try {
					pessoaDAO.add(pessoa,aluno,usuario);
					addAluno();
					FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Aluno", "Adicionado com sucesso!")));
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao criar o usuário!")));
					System.out.println("ERRO E BEAN: " + e.toString());
				}
			}
		}
		else {
			if(!usuario.getCdSenha().equals(confirmeSenha)){
				FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Senhas diferentes!")));		
			}
			else {
				usuario.setCdSenha( MD5.md5(usuario.getCdSenha()) );
				usuario.setCdEmail(pessoa.getEmail());
				tipoUsuario = new TipoUsuario();
				tipoUsuario.setId(2);
				usuario.setTipoUsuario(tipoUsuario);
				usuario.setEmpresa(empresa);
				usuario.setPessoa(pessoa);	
				try {
					empresaDAO.add(empresa, pessoa, usuario);
					addEmpresa();
					FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Empresa", "Adicionada com sucesso!")));
				} catch (DAOException e) {
					FacesContext.getCurrentInstance().addMessage(null, (new FacesMessage("Erro ao incluir a Empresa")));
				}
			}
		}
	}
	
	
}
